package org.luvx.remember.sort;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;

public class SortTest {
    int[]       array  = {5, 4, 3, 2, 1};
    int[]       array1 = {3, 2, 1, 6, 5, 7, 4};
    List<int[]> list   = List.of(array, array1);

    @Test
    public void test0() {
        BubbleSort.sort0(this.array);
    }

    @Test
    public void test1() {
        list.forEach(array -> {
            QuickSort.sort(array, 0, array.length - 1);
        });
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }


    @After
    public void after() {
        list.forEach(array -> {
            System.out.println(Arrays.toString(array));
        });
    }
}