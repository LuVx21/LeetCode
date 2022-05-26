package org.luvx.leetcode.java.medium._817;

import org.luvx.leetcode.link.ListNode;

// @lc code=start
import java.util.HashSet;
/*
 * @lc app=leetcode.cn id=817 lang=java
 *
 * [817] 链表组件
 */

/**
 * 给定链表头结点 head，该链表上的每个结点都有一个唯一的整型值 。
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
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
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }
        boolean flag = false;
        int cnt = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                flag = true;
            } else if (flag) {
                cnt++;
                flag = false;
            }
            head = head.next;
        }
        return flag ? cnt + 1 : cnt;
    }
}
// @lc code=end

