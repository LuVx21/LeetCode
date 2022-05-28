package org.luvx.leetcode.java;

import org.junit.jupiter.api.Test;

public class MediumTest extends BaseTest {

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
    void m560() {
        int[] array = {1, 2, 3, 0, 3};
        exec(560, "subarraySum",
                array, 3, array, 5
        );
    }
}
