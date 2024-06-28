package org.luvx.remember.tree;

import com.alibaba.fastjson2.JSON;
import org.luvx.leetcode.tree.TreeNode;
import org.luvx.leetcode.util.TreeUtils;

/**
 * 二叉搜索树
 */
public class BinSearchTree {

    /**
     * 插入节点
     *
     * @param obj 假设元素不在现有树中
     * @return root
     */
    public static TreeNode insert(TreeNode root, int obj) {
        if (root == null) {
            return new TreeNode(obj);
        }

        if (root.val < obj) {
            if (root.right == null) {
                root.right = new TreeNode(obj);
            } else {
                insert(root.right, obj);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(obj);
            } else {
                insert(root.left, obj);
            }
        }
        return root;
    }

    // 删除节点
    public static void delete(TreeNode root, int obj) {
    }

    /**
     * 查找节点: 递归实现
     *
     * @param root 根节点
     * @param obj  查找值
     */
    public static void search(TreeNode root, int obj) {
        if (root == null)
            return;
        if (root.val == obj) {
            System.out.println("OK");
        } else if (obj < root.val) {
            System.out.println("左子树......");
            search(root.left, obj);
        } else {
            System.out.println("右子树......");
            search(root.right, obj);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBST(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
        root = insert(root, 18);
        System.out.println(JSON.toJSONString(root));
    }
}

