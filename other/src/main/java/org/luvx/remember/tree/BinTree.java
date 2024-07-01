package org.luvx.remember.tree;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import org.luvx.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 前序遍历 {@link org.luvx.leetcode.java.medium._144.Solution}
 * <p>
 * 中序遍历 {@link org.luvx.leetcode.java.medium._94.Solution}
 * <p>
 * 后序遍历 {@link org.luvx.leetcode.java.medium._145.Solution}
 * <p>
 * 层级遍历: {@link org.luvx.leetcode.java.medium._102.Solution}
 */
public class BinTree {
    // region 前序遍历

    /**
     * 前序遍历:递归方式
     *
     * @param root 根节点
     */
    public static void preSearch(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preSearch(root.left);
        preSearch(root.right);
    }

    /**
     * 前序遍历:循环方式
     *
     * @param root
     */
    public static void preSearchByLoop(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty())
                break;
            root = stack.pop().right;
        }
    }

    /**
     * 前序遍历:循环方式
     *
     * @param root
     */
    public static void preSearchByLoop1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.val);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
    }
    // endregion

    // region 中序遍历

    /**
     * 中序遍历:递归方式
     *
     * @param root 根节点
     */
    public static void inSearch(TreeNode root) {
        if (root == null)
            return;
        inSearch(root.left);
        System.out.println(root.val);
        inSearch(root.right);
    }

    /**
     * 中序遍历:循环方式
     *
     * @param root 根节点
     */
    public static void inSearchByLoop(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty())
                break;
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static IntList inSearchByLoop1(TreeNode root) {
        if (root == null) {
            return IntList.of();
        }

        IntArrayList list = new IntArrayList();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
    // endregion


    // region 后序遍历

    /**
     * 后序遍历:递归方式
     *
     * @param root 根节点
     */
    public static void postSearch(TreeNode root) {
        if (root == null)
            return;
        postSearch(root.left);
        postSearch(root.right);
        System.out.println(root.val);
    }

    /**
     * 后序遍历:循环方式
     *
     * @param root 根节点
     */
    public static void postSearchByLoop(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty())
                    return;

                if (stack.lastElement().right == null) {
                    root = stack.pop();
                    System.out.println(root.val);
                    while (!stack.isEmpty() && root == stack.lastElement().right) {
                        root = stack.pop();
                        System.out.println(root.val);
                    }
                }
                root = !stack.isEmpty() ? stack.lastElement().right : null;
            }
        }
    }
    // endregion

    // region 层级遍历

    /**
     * 层级遍历
     */
    public static void levelSearch(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode temp = null;
        int currentLevel = 1;    // 记录当前层需要打印的节点的数量
        int nextLevel = 0;// 记录下一层需要打印的节点的数量
        while ((temp = queue.poll()) != null) {
            System.out.print(temp.val + " ");

            if (temp.left != null) {
                queue.add(temp.left);
                nextLevel++;

            }
            if (temp.right != null) {
                queue.add(temp.right);
                nextLevel++;
            }

            currentLevel--;
            if (currentLevel == 0) {
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }

    /**
     * 层级遍历
     */
    public static void levelOrder(TreeNode root) {
        TreeNode temp;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.println(temp.val);
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }
    // endregion
}
