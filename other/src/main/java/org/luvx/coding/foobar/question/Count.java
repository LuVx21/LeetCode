package org.luvx.coding.foobar.question;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程输出奇偶数
 * <p>
 * 线程的基础知识
 * 线程通信
 * 锁的使用
 */
public class Count {

    // region 方式1
    public class TwoNumWaitNotify {
        private volatile int     num  = 1;
        /**
         * 输入奇数还是偶数的控制flag
         */
        private volatile boolean flag = false;

        @AllArgsConstructor
        public class OuNum implements Runnable {
            private TwoNumWaitNotify num;

            @Override
            public void run() {
                while (num.num <= 100) {
                    synchronized (num) {
                        if (num.flag) {
                            System.out.println(Thread.currentThread().getName() + ":" + num.num);
                            num.num++;
                            num.flag = !num.flag;
                            num.notify();
                        } else {
                            try {
                                num.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        @AllArgsConstructor
        public class JiNum implements Runnable {
            private TwoNumWaitNotify num;

            @Override
            public void run() {
                while (num.num <= 100) {
                    synchronized (num) {
                        if (!num.flag) {
                            System.out.println(Thread.currentThread().getName() + ":" + num.num);
                            num.num++;
                            num.flag = !num.flag;
                            num.notify();
                        } else {
                            try {
                                num.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
    // endregion

    // region 方式2
    public class TwoNumLock {
        private volatile int     num  = 1;
        /**
         * 输入奇数还是偶数的控制flag
         */
        private volatile boolean flag = false;

        private final static Lock LOCK = new ReentrantLock();

        @AllArgsConstructor
        public class OuNum implements Runnable {
            private TwoNumLock num;

            @Override
            public void run() {
                while (num.num <= 100) {
                    if (num.flag) {
                        try {
                            LOCK.lock();
                            System.out.println(Thread.currentThread().getName() + ":" + num.num);
                            num.num++;
                            num.flag = !num.flag;
                        } finally {
                            LOCK.unlock();
                        }
                    }
                }
            }
        }

        @AllArgsConstructor
        public class JiNum implements Runnable {
            private TwoNumLock num;

            @Override
            public void run() {
                while (num.num <= 100) {
                    if (!num.flag) {
                        try {
                            LOCK.lock();
                            System.out.println(Thread.currentThread().getName() + ":" + num.num);
                            num.num++;
                            num.flag = !num.flag;
                        } finally {
                            LOCK.unlock();
                        }
                    }
                }
            }
        }
    }
    // endregion

    // region 方式3
    public class TwoNumNonBlock implements Runnable {
        /**
         * 当flag为1时只有奇数线程可以执行, 并将其置为0
         * 当flag为0时只有偶数线程可以执行, 并将其置为1
         */
        private volatile static int flag = 1;
        private                 int num;

        private TwoNumNonBlock(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (num <= 100) {
                int f = flag;
                if ((num & 0x01) == f) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num += 2;
                    flag ^= 0x1;
                }
            }
        }
    }
    // endregion
}
