package org.luvx.leetcode.util;

import com.google.common.collect.Lists;
import org.luvx.coding.common.more.MorePrints;
import org.luvx.leetcode.tree.TreeNode;

import jakarta.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class TreeUtils {

    /**
     * 将数组构建成完全二叉树
     * 数组中存在null, 则构成的不是完全而是普通二叉树
     *
     * @param array 二叉树的完全二叉树形式的数组(二叉树层次遍历的顺序)
     */
    public static TreeNode buildCBT(Integer... array) {
        int length = array.length;
        if (length == 1) {
            return TreeNode.of(array[0]);
        }

        List<TreeNode> list = Arrays.stream(array)
                .map(i -> i == null ? null : TreeNode.of(i))
                .toList();
        for (int i = 0; 2 * i + 1 < length; i++) {
            TreeNode n = list.get(i);
            if (n == null) {
                continue;
            }
            n.left = list.get(2 * i + 1);
            if (2 * i + 2 < length) {
                n.right = list.get(2 * i + 2);
            }
        }
        return list.getFirst();
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

    /**
     * 输出二叉树的树形结构
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        List<List<Integer>> levelRows = Lists.newArrayList();
        levelRows.add(Lists.newArrayList(root.val));
        List<TreeNode> queue = Lists.newArrayList(root);
        // queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> row = Lists.newArrayList();
            if (!levelRows.isEmpty()) {
                for (Integer val : levelRows.getLast()) {
                    if (val == null) {
                        row.add(null);
                        row.add(null);
                    }
                }
            }

            List<TreeNode> next = Lists.newArrayList();
            for (TreeNode node : queue) {
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    next.add(left);
                    row.add(left.val);
                } else {
                    row.add(null);
                }

                if (right != null) {
                    next.add(right);
                    row.add(right.val);
                } else {
                    row.add(null);
                }
            }
            levelRows.add(row);
            queue = next;
        }
        for (List<Integer> row : levelRows) {
            System.out.println(row);
        }
        System.out.println("-".repeat(150));
        dumpTreeFormat0(levelRows);
        System.out.println("-".repeat(150));
        dumpTreeFormat(levelRows);
    }

    private static void dumpTreeFormat0(List<List<Integer>> rowList) {
        int pow = (int) Math.pow(2, rowList.size() - 1);

        for (int i = 0; i < rowList.size(); i++) {
            int step = (int) Math.pow(2, rowList.size() - 1 - i);
            String[] row = new String[pow];
            Arrays.fill(row, "    ");
            List<Integer> vals = rowList.get(i);
            for (int j = 0; j < vals.size(); j++) {
                Integer v = vals.get(j);
                row[j * step] = v == null ? "    " : String.format("%4d", v);
            }
            System.out.println(STR."No.\{i}|\{String.join("", row)}");
        }
    }

    private static void dumpTreeFormat(List<List<Integer>> rowList) {
        int width = rowList.size();
        for (int i = 0; i < rowList.size(); i++) {
            // 填充左侧空格
            String prefix = "  ".repeat(width - i - 1);
            System.out.print(prefix);

            // 从第二层开始, 节点连接符
            List<Integer> row = rowList.get(i);
            if (i >= 1) {
                for (int j = 0; j < row.size(); j++) {
                    String s = row.get(j) == null ? "  " : ((j & 1) == 0 ? " / " : "\\  ");
                    System.out.print(s);
                }
                System.out.println();
                System.out.print(prefix);
            }
            // 填充数字
            for (Integer v : row) {
                System.out.print(v == null ? "  " : v + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = buildCBT(3, 9, 2, 7, 8, 5, 7, null, null, null, null, 1, 2, 6, 8);
        printTree(root);
    }
}
