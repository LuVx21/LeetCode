package org.luvx.offer.array;

/**
 * 输入数字n，按顺序打印出从1最大的n位十进制数。
 * 比如输入3，则打印出1、2、3 一直到最大的3位数即999。
 */
public class Offer12 {
    public void printOneToNthDigits1(int n) {
        if (n <= 0) {
            throw new RuntimeException("The input number must larger than 0");
        }
        int[] arr = new int[n];
        printOneToNthDigits1(0, arr);
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     *
     * @param n 当前处理的是第个元素，从0开始计数
     * @param arr 存放结果的数组
     */
    private void printOneToNthDigits1(int n, int[] arr) {
        // 说明所有的数据排列选择已经处理完了
        if (n >= arr.length) {
            // 可以输入数组的值
            printArray(arr);
        } else {
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits1(n + 1, arr);
            }
        }
    }

    /**
     * 少用内存空间
     */
    public void printOneToNthDigits2(int n) {
        if (n <= 0) {
            throw new RuntimeException("The input number must larger than 0");
        }
        int[] arr = new int[n];
        while (addOne(arr)) {
            printArray(arr);
        }
    }

    /**
     * 对arr表示的数组的最低位加1 arr中的每个数都不能超过9不能小于0，每个位置模拟一个数位
     *
     * @param arr 待加数组
     * @return 判断最高位是否有进位，如果有进位就返回false，否则返回true
     */
    private boolean addOne(int[] arr) {
        int carry = 1;
        for (int i = arr.length - 1; i >= 0 && carry > 0; i--) {
            int sum = arr[i] + carry;
            carry = sum / 10;
            arr[i] = sum % 10;
        }
        // 执行到此处: 没有进位或数组遍历完
        return carry <= 0;
    }

    /**
     * 输入数组的元素，从左边第一个非0值到最右元素
     *
     * @param arr 要输出的数组
     */
    private void printArray(int[] arr) {
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}
