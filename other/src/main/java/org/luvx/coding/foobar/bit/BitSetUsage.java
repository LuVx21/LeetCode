package org.luvx.coding.foobar.bit;

import java.util.BitSet;

public class BitSetUsage {
    final int qw = 1000_0000, yi = 1_0000_0000;

    /**
     * 有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来
     */
    public void a(int[] array) {
        BitSet bitSet = new BitSet(yi);
        for (int i = 0; i < qw; i++) {
            bitSet.set(array[i]);
        }

        for (int i = 0; i < yi; i++) {
            if (!bitSet.get(i)) {
                // System.out.println(i);
            }
        }
    }
}
