package org.luvx.remember.a;

public class L2CacheTest {
    public static final int MAX_SIZE = 20;
    public static       int count    = 0;

    /**
     * 将虚拟机参数设置为-Xms64M -Xmx64M
     *
     * @param args
     */
    public static void main(String[] args) {
        //一级缓存,利用linkedHashMap的LRU特性
        L2Cache.FirstCache<Integer, Student> firstCache = new L2Cache.FirstCache<>(20);
        // HashMap<Integer, Student> m = new HashMap<>();
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