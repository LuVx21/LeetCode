package org.luvx.remember.sort;

import org.junit.Test;

import java.util.Arrays;

public class SortTest {
    int[] array = {5, 4, 3, 2, 1};

    @Test
    public void test() {
        SimpleSort.sort5(array);
        System.out.println(Arrays.toString(array));
    }
}