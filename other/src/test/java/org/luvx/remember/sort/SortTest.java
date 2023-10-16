package org.luvx.remember.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    public void mergeSortTest() {
        list.forEach(MergeSort::sort);
    }

    @Test
    public void heapSortTest() {
        list.forEach(HeapSort::sort);
    }

    @Test
    public void radixSortTest() {
        list.forEach(RadixSort::sort);
    }

    @AfterEach
    public void after() {
        list.forEach(array -> {
            System.out.println(Arrays.toString(array));
        });
    }
}