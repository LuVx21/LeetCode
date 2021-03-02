package org.luvx.question.array;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.vavr.Tuple2;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SumZeroPair {
    /**
     * 给出一个乱序的数组，且元素可能重复，找出和为0的所有数字对
     * 假设数组中不存在 0
     * <p>
     * 例:
     * -1,1,1,2,3,-2
     * [0,1] [0,2] [3,5]
     */
    public List<Tuple2<Integer, Integer>> sumZeroPair(int[] array) {
        HashMap<Integer, List<Integer>> map = Maps.newHashMapWithExpectedSize(array.length);
        for (int i = 0; i < array.length; i++) {
            map.computeIfAbsent(array[i], k -> Lists.newArrayList()).add(i);
        }

        List<Tuple2<Integer, Integer>> result = Lists.newArrayList();
        Set<Integer> has = Sets.newHashSet();
        for (int i = 0; i < array.length; i++) {
            if (has.contains(array[i])) {
                continue;
            }
            List<Integer> is = map.get(-array[i]);
            if (is != null) {
                for (Integer n : is) {
                    result.add(new Tuple2<>(i, n));
                }
                has.add(-array[i]);
            }
        }
        return result;
    }
}
