package org.luvx.remember.a;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * L2 LRU
 */
public class L2Cache {
    public static class FirstCache<K, V> extends LinkedHashMap<K, V> {
        private static final long              serialVersionUID = 1L;
        private              int               MAX_SIZE         = 100;
        private final        SecondCache<K, V> secondCache      = new SecondCache<>();

        public FirstCache() {
            super();
        }

        /**
         * 利用LinkedHashMap构造方法的accessOrder属性来构建LRU缓存
         * accessOrder为true时，按照访问顺序排序，当accessOrder为false时，按照插入顺序排序
         */
        public FirstCache(int maxSize) {
            super(100, 0.75f, true);
            this.MAX_SIZE = maxSize;
        }

        /**
         * 当map调用put或者putAll方法成功插入一个entry时
         * 根据removeEldestEntry返回的bool值来确定是否删除least recently used对应的数据
         *
         * @param entry pair
         * @return true: 删除 false: 保留
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            if (size() >= MAX_SIZE) {
                /// 用SoftReference的特点来做二级缓存，SoftReference(软引用)只有在即将oom的时候 GC才会回收
                secondCache.put(entry.getKey(), entry.getValue());
                System.out.println("二级缓存容量" + secondCache.notEmptySize());
                return true;
            }
            return false;
        }
    }

    private static class SecondCache<K, V> {
        Map<K, SoftReference<V>> secondCacheMap = new HashMap<>();

        public void put(K k, V v) {
            secondCacheMap.put(k, new SoftReference<V>(v));
        }

        /**
         * 将value为null的键值对删除，返回整个map中value不为null的数量
         */
        public int notEmptySize() {
            int count = 0;
            Iterator<Map.Entry<K, SoftReference<V>>> iter = secondCacheMap.entrySet().iterator();
            while (iter.hasNext()) {
                if (iter.next().getValue().get() == null) {
                    iter.remove();
                } else {
                    count++;
                }
            }
            return count;
        }
    }
}
