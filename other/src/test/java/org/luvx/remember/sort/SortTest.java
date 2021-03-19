package org.luvx.remember.sort;

import org.junit.After;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {
    int[] array = {5, 4, 3, 2, 1};

    @Test
    public void test0() {
        BubbleSort.sort0(array);
    }

    @Test
    public void test1() {
        QuickSort.sort(array, 0, array.length - 1);
    }

    @Test
    public void test2() {
        SimpleSort.sort5(array);
    }

    @Test
    public void test3() {
        int i = 10;
        a(i++);
        System.out.println(i);
    }

    private void a(int i) {
        System.out.println(i);
    }

    @After
    public void after() {
        System.out.println(Arrays.toString(array));
    }
}