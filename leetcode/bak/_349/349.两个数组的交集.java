/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                list.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }

        return toArray(list);
    }

    public int[] intersection0(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 == 0 || l2 == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // List<Integer> result = new ArrayList<>();
        Set<Integer> result = new LinkedHashSet<>();

        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            int aa = nums1[i];
            int bb = nums2[j];
            if (aa == bb) {
                result.add(aa);
                i++;
                j++;
            } else if (aa < bb) {
                i++;
            } else {
                j++;
            }
        }

        return toArray(result);
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> result = new LinkedHashSet<>();
        Queue<Integer> a1 = intoQueue(nums1);
        Queue<Integer> a2 = intoQueue(nums2);

        while (!a1.isEmpty() && !a2.isEmpty()) {
            int aa = a1.peek();
            int bb = a2.peek();
            if (aa == bb) {
                result.add(aa);
                a1.poll();
                a2.poll();
            } else if (aa < bb) {
                a1.poll();
            } else {
                a2.poll();
            }
        }

        return toArray(result);
    }

    private Queue<Integer> intoQueue(int[] array) {
        Arrays.sort(array);
        Queue<Integer> queue = new ArrayBlockingQueue(array.length);
        for (int i : array) {
            queue.add(i);
        }
        return queue;
    }

    private int[] toArray(Collection<Integer> list) {
        Objects.requireNonNull(list, "参数为空");
        int[] array = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int index = 0;
        while (it.hasNext()) {
            array[index++] = it.next();
        }
        return array;
    }
}

// 使用队列