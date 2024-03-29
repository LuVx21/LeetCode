package org.luvx.leetcode.java;

import org.junit.jupiter.api.Test;

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
    void m421() {
        int[] array = {3, 10, 5, 25, 2, 8};
        // int[] array = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        exec(421, "findMaximumXOR", array);
    }

    @Test
    void m560() {
        int[] array = {1, 2, 3, 0, 3};
        exec(560, "subarraySum",
                array, 3, array, 5
        );
    }
}
