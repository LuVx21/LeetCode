package org.luvx.leetcode.util;

import org.luvx.leetcode.tree.TreeNode;

import jakarta.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class TreeUtils {

    /**
     * 将数组构建成完全二叉树
     */
    public static TreeNode buildCBT(int... array) {
        int length = array.length;
        if (length == 1) {
            return TreeNode.of(array[0]);
        }
        List<TreeNode> list = Arrays.stream(array).mapToObj(TreeNode::of).toList();
        for (int i = 0; 2 * i + 1 < length; i++) {
            list.get(i).left = list.get(2 * i + 1);
            if (2 * i + 2 < length) {
                list.get(i).right = list.get(2 * i + 2);
            }
        }
        return list.get(0);
    }

    /**
     * 构建二叉搜索树
     * LeetCode No.108
     *
     * @param array 元素无重复
     */
    @Nullable
    public static TreeNode buildBST(int... array) {
        if (array.length == 1) {
            return new TreeNode(array[0]);
        }
        Arrays.sort(array);
        return tree(array, 0, array.length - 1);
    }

    private static TreeNode tree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int i = left + (right - left) / 2;
        if (i < 0 || i >= nums.length) {
            return null;
        }

        TreeNode root = new TreeNode(nums[i]);
        root.left = tree(nums, left, i - 1);
        root.right = tree(nums, i + 1, right);
        return root;
    }
}
