package org.luvx.coding.foobar.bit;

import java.util.stream.Stream;

public class Main {

    /**
     * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
     * 不限制操作
     * 关联: No.1342
     */
    public int numberOfSteps(int num) {
        // return Integer.bitCount(num);
        int count = 0;
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

    void main() {
        Stream.of(14, 8, 123)
                .map(this::numberOfSteps)
                .forEachOrdered(System.out::println);
    }
}
