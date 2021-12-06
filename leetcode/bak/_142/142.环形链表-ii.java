/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

/**
 * Definition for singly-linked list.
 * <pre>
 * class ListNode {
 *     int      val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * </pre>
 * }
 */
public class Solution {
    /**
     * 1->2->3->4
     * 1->2->3->4->5
     * 快慢指针: 快与慢之间的距离会越来越大(每进行一次移动,差距加1),
     * 最终赶超一圈和慢指针指向相同, 此时快指针和头指针距离环入口距离相同, 等于环外节点数
     * 之后快指针和头指针同步移动直到指向相同
     * <p>
     * 至于为什么距离相同:
     * 可假设环外节点数为m, 环内为n
     * 当指向相同时, 假设慢指针移动x次, 快慢指针位置差则为x
     * 其中x = n, 则位置分别为n+1, 2n+1,
     * 快指针距离环入口为m+2n+1-(2n+1)=m
     * <p>
     * 时间复杂度: O(m+2n)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != fast) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }

    /**
     * 存在环时, 环起点的前一节点会存在两个
     * 一个是入环的前一个, 一个是再次入环的前一个
     * 如果一个节点的2个前置不同, 则为环的起点
     */
    public ListNode detectCycle0(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode current = head, pre = null;
        while (current != null) {
            ListNode pre1 = null, current1 = head;
            while (true) {
                if (current1 == current) {
                    if (pre1 != pre) {
                        return current;
                    }
                    break;
                }
                pre1 = current1;
                current1 = current1.next;
            }
            pre = current;
            current = current.next;
        }
        return null;
    }

    /**
     * 使用set存储访问过的节点, 当首次出现重复时, 则是环的起点
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}

