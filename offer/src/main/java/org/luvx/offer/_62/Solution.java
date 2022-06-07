package org.luvx.offer._62;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 长度为 n 的环, 从 0 开始删除第 m 个数字, 找到最后一个
     * 约瑟夫环
     * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
     * <pre>
     *     0,1,2,3,4 - 3
     *     0,1,3,4
     *     1,3,4
     *     1,3
     *     3
     * </pre>
     */
    public int lastRemaining(int n, int m) {
        // 记录上一次最后被删除数的位置
        int lastNum = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            // 由于lastNum可能会大于i所以这里需要取模
            lastNum = (lastNum + m) % i;
        }
        return lastNum;
    }

    int lastRemaining1(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int num = 0;
        for (int i = n; i > 1; i--) {
            num = (num + m - 1) % i;
            list.remove(num);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        // System.out.println(exec.lastRemaining1(5, 3));
        // System.out.println(exec.lastRemaining1(10, 17));
        System.out.println(exec.lastRemaining1(100, 20));
    }
}