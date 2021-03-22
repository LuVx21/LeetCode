package org.luvx.leetcode.java.medium._725;

import org.luvx.leetcode.ListNode;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
 */

/**
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * Definition for singly-linked list.
 * <pre>
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * </pre>
 */
class Solution {
    /**
     * 1-2-3-4 5
     * ↓
     * [ [1], [2], [3], [4], null ]
     * <p>
     * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     * 3
     * ↓
     * [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = size(root), i = size / k, j = size % k;
        ListNode[] array = new ListNode[k];
        for (int l = 0; l < k; l++) {
            array[l] = root;
            for (int cnt = 0; cnt < i + (l < j ? 1 : 0) - 1; cnt++) {
                root = root.next;
            }
            if (root != null) {
                ListNode prev = root;
                root = root.next;
                prev.next = null;
            }
        }
        return array;
    }

    public ListNode[] splitListToParts0(ListNode root, int k) {
        int size = size(root), i = size / k;
        int[] nums = new int[k];
        Arrays.fill(nums, i);
        int j = size % k;
        for (int l = 0; l < j; l++) {
            nums[l] += 1;
        }
        ListNode[] array = new ListNode[k];
        for (int l = 0; l < k; l++) {
            array[l] = root;
            int cnt = nums[l];
            if (cnt == 0) {
                continue;
            }
            for (; cnt > 1; cnt--) {
                root = root.next;
            }
            ListNode next = root.next;
            root.next = null;
            root = next;
        }
        return array;
    }

    private int size(ListNode l) {
        int cnt = 0;
        while (l != null) {
            cnt++;
            l = l.next;
        }
        return cnt;
    }
}
// @lc code=end

