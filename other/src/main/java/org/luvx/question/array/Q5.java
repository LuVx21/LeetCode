package org.luvx.question.array;

/**
 * 有序二维数组内查找
 */
public class Q5 {
    public static boolean findInArray1(int[][] array, int target) {
        int row = array.length - 1, col = 0;
        while (col < array[0].length && row >= 0) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                System.out.println("第" + (row + 1) + "行第" + (col + 1) + "个");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        findInArray1(array, 6);
    }
}
