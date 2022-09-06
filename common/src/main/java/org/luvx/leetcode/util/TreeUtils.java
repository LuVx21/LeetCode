package org.luvx.leetcode.util;

import java.util.Arrays;
import java.util.List;

import org.luvx.leetcode.tree.TreeNode;

public class TreeUtils {

    /**
     * 将数组构建成完全二叉树
     */
    public static TreeNode buildCBT(int[] array) {
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
}
