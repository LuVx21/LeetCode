package org.luvx.coding.foobar.bit;

public class Subtract {
    /**
     * 位运算实现减法
     * 关联: No.371
     */
    public int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }
}
