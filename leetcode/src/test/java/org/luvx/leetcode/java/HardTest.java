package org.luvx.leetcode.java;

import org.junit.jupiter.api.Test;

class HardTest extends BaseTest {
    @Test
    void m84() {
        int[][] arg = new int[][]{
                {1, 2, 4, 5, 3},
                {1, 2, 4, 5, 3, 2},
                {1, 2, 4, 5, 3, 4},
                {1, 2, 4, 5, 3, 6},
                {6, 2, 1},
                {1, 2, 6},
                {3, 1, 6, 4, 5, 2},
                {5, 6},
                {2, 1, 5, 6, 2, 3}
        };

        exec(84, "largestRectangleArea", arg);
    }
}
