package org.luvx.leetcode.util;

import com.google.common.collect.Lists;
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
        if (length == 0) {
            return null;
        }
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
    public static String printTree(TreeNode root) {
        if (root == null) {
            return "";
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
            if (!next.isEmpty()) {
                levelRows.add(row);
            }
            queue = next;
        }
        // for (List<Integer> row : levelRows) {
        //     System.out.println(row);
        // }
        String line = "-".repeat(150);
        return dumpTreeFormat0(levelRows)
                .append(line).append("\n")
                .append(dumpTreeFormat(levelRows))
                .append(line).append("\n")
                .toString()
                ;
    }

    private static StringBuilder dumpTreeFormat0(List<List<Integer>> rowList) {
        int width = 2;
        for (List<Integer> a : rowList) {
            for (Integer i : a) {
                String s = i == null ? "" : String.valueOf(i);
                width = Math.max(width, s.length());
            }
        }
        final String space = " ".repeat(width);

        StringBuilder sb = new StringBuilder("\n");
        int length = (int) Math.pow(2, rowList.size()) - 1;
        for (int i = 0; i < rowList.size(); i++) {
            String[] row = new String[length];
            Arrays.fill(row, space);

            int step = (int) Math.pow(2, rowList.size() - i), start = (step >> 1) - 1;
            List<Integer> vals = rowList.get(i);
            for (int j = 0; j < vals.size(); j++) {
                Integer v = vals.get(j);
                int k = start + step * j;
                row[k] = v == null ? space : String.format(STR."%\{width}d", v);
            }
            // if (i == 0) {
            //     String[] r = new String[length];
            //     for (int j = 0; j < r.length; j++) {
            //         r[j] = String.format(STR."%\{width}d", j);
            //     }
            //     System.out.println(STR."层id|\{String.join("", r)}");
            // }
            // System.out.println(STR."No.\{i}|\{String.join("", row)}".trim());
            sb.append(STR."No.\{i}|\{String.join("", row)}".trim()).append("\n\n");
        }
        return sb;
    }

    private static StringBuilder dumpTreeFormat(List<List<Integer>> rowList) {
        int width = rowList.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowList.size(); i++) {
            // 填充左侧空格
            String prefix = "  ".repeat(width - i - 1);
            // System.out.print(prefix);
            sb.append(prefix);

            // 从第二层开始, 节点连接符
            List<Integer> row = rowList.get(i);
            if (i >= 1) {
                for (int j = 0; j < row.size(); j++) {
                    String s = row.get(j) == null ? "  " : ((j & 1) == 0 ? " / " : "\\  ");
                    // System.out.print(s);
                    sb.append(s);
                }
                // System.out.println();
                // System.out.print(prefix);
                sb.append("\n").append(prefix);
            }
            // 填充数字
            for (Integer v : row) {
                // System.out.print(v == null ? "  " : v + "   ");
                sb.append(v == null ? "  " : v + "   ");
            }
            // System.out.println();
            sb.append("\n");
        }
        return sb;
    }

    public static void main(String[] args) {
        TreeNode root = buildBST(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
        // TreeNode root = buildCBT(3, 9, 2, 7, 8, 5, 7, null, null, null, null, 1, 2, 6, 8);
        printTree(root);
    }
}
