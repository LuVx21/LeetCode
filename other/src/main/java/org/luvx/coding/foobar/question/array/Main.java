package org.luvx.coding.foobar.question.array;

public class Main {
    /**
     * [来源](http://www.yinwang.org/blog-cn/2020/02/13/java-type-system)
     * <p>
     * 这段代码里面到底哪一行错了? 为什么? 如果某个 Java 版本能顺利运行这段代码, 那么如何让这个错误暴露得更致命一些?
     * <p>
     * 注意这里所谓的「错了」是本质上, 原理上的, 而不一定是 Java 编译器, IDE 或者运行时报给你的. 也就是说, 你用的 Java 实现, IDE 都可能是错的, 没找对真正错误的地方, 或者没告诉你真正的原因.
     * <p>
     * 如果你知道哪里错了, 并且知道「为什么」错了, 可以联系我.
     */
    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        // 异常
        b[1] = Integer.valueOf(42);
    }

    /**
     * 两个char型数组, 只有一个元素不同, 且其他的相同元素的相对位置也都是一致的, 请找出那个不同(有可能是多一个元素).
     * char[] array = new char[65536]
     * 两次循环
     */
}
