/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * <pre>
     *     5
     *    / \
     *   3   7
     *  /     \
     * 1       9
     * </pre>
     * 给定一个单链表, 其中的元素按升序排序, 将其转换为高度平衡的二叉搜索树.
     * 本题中, 一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1.
     * 从中间分割链表为h1和h2, 其中h2可能比h1多一个元素
     * 如果h1比h2多一个元素, 则不能通过
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = head, slow = pre.next, fast = slow.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = pre.next;
            slow = pre.next;
        }
        pre.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}

