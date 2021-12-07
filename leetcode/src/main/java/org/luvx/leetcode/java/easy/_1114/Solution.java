package org.luvx.leetcode.java.easy._1114;

// @lc code=start
/*
 * @lc app=leetcode.cn id=1114 lang=java
 *
 * [1114] 按序打印
 */
class Foo {
    private final Object lock;
    private volatile int a;

    public Foo() {
        lock = new Object();
        a = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            a = 2;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (a < 2) {
                lock.wait();
            }
            printSecond.run();
            a = 3;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (a < 3) {
                lock.wait();
            }
            printThird.run();
        }
    }
}
// @lc code=end
