package org.luvx.leetcode.java;

import org.junit.jupiter.api.Test;
import org.luvx.leetcode.link.ListNode;

import static org.luvx.leetcode.util.LinkUtils.initLinked;

class MediumTest extends BaseTest {
    @Test
    void m34() {
        int[] array = {5, 7, 7, 8, 8, 9, 10};
        exec(34, "searchRange",
                array, 8,
                array, 9,
                array, 11
        );
    }

    @Test
    void m137() {
        int[] i1 = {2, 2, 3, 2};
        int[] i2 = {0, 1, 0, 1, 0, 1, 99};
        exec(137, "singleNumber", i1, i2);
    }

    @Test
    void m201() {
        exec(201, "rangeBitwiseAnd", 5, 7, 0, 0, 1, 2147483646);
    }

    @Test
    void m371() {
        exec(371, "getSum", 1, 2, 2, 3);
    }

    @Test
    void m421() {
        int[] array = {3, 10, 5, 25, 2, 8};
        // int[] array = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        exec(421, "findMaximumXOR", array);
    }

    @Test
    void m477() {
        int[] array1 = {4, 14, 2};
        int[] array2 = {4, 14, 4};
        exec(477, "totalHammingDistance", array1, array2);
    }

    @Test
    void m560() {
        int[] array = {1, 2, 3, 0, 3};
        exec(560, "subarraySum",
                array, 3, array, 5
        );
    }

    @Test
    void m739() {
        int[][] array = {
                {73, 74, 75, 71, 69, 72, 76, 73}, {30, 40, 50, 60}, {30, 60, 90},
                {89, 62, 70, 58, 47, 47, 46, 76, 100, 70},
                {34, 80, 80, 34, 34, 80, 80, 80, 80, 34}
        };
        exec(739, "dailyTemperatures", array);
    }

    @Test
    void m1669() {
        ListNode list1 = initLinked(0, 1, 2, 3, 4, 5), list2 = initLinked(1000000, 1000001, 1000002);
        exec(1669, "mergeInBetween", list1, 3, 4, list2,
                initLinked(0, 1, 2, 3, 4, 5, 6),
                2, 5,
                initLinked(1000000, 1000001, 1000002, 1000003, 1000004)
        );
    }
}
