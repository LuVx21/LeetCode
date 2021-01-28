package org.luvx.remember.a;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class L2Cache {
    private static class FirstCache<K, V> extends LinkedHashMap<K, V> {
        private static final long              serialVersionUID = 1L;
        private              int               MAX_SIZE         = 100;
        private              SecondCache<K, V> secondCache      = new SecondCache<K, V>();

        public FirstCache() {
            super();
        }

        public FirstCache(int max_size) {
            /**
             * 利用linkedHashMap构造方法的accessOrder属性来构建LRU缓存
             * accessOrder为true时，按照访问顺序排序，当accessOrder为false时，按照插入顺序排序
             */
            super(100, 0.75f, true);
            this.MAX_SIZE = max_size;
        }

        /**
         * 当map调用put或者putall方法成功插入一个entry时，根据removeEldestEntry返回的bool值来确定是否删除least recently used对应的数据
         * 返回true删除返回false保留
         *
         * @param entry
         * @return
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            if (size() >= MAX_SIZE) {
                //用softreference的特点来做二级缓存，softreference(软引用)只有在即将oom的时候 GC才会回收
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
            SoftReference<Object> o = new SoftReference<>(new Object());
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

    public static final int MAX_SIZE = 20;
    public static       int count    = 0;

    /**
     * 将虚拟机参数设置为-Xms64M -Xmx64M
     *
     * @param args
     */
    public static void main(String[] args) {
        //一级缓存,利用linkedHashMap的LRU特性
        FirstCache<Integer, Student> firstCache = new FirstCache<>(20);
//        HashMap<Integer, Student> m = new HashMap<>();
        while (true) {
            count++;
            Student s = new Student();
            //如果直接使用hashmap来存放，在count大约59的时候就抛出OOM了
            // m.put(count, s);
            // System.out.println(count);
            firstCache.put(count, s);
            if (count > MAX_SIZE) {
                System.out.println(firstCache.size());
            }
        }
    }

    /**
     * 占用1M数据
     */
    static class Student {
        public byte[] data = new byte[1024 * 1024];
    }
}
