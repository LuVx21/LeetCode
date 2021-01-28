package org.luvx.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组内, 元素最大重复次数
 * <p>
 * 只需要次数时:
 * int [] aa = new int[array.length];
 */
public class AA {

    /**
     * 出现次数最多的字符串及次数
     * 元素最大重复次数=出现次数 - 1
     * 1,2,2,3,3,3,3,4
     *
     * @param array
     * @return
     */
    private Object[] bb(String[] array) {
        if (array == null || array.length == 0) {
            return new Object[0];
        }
        Map<String, Integer> map = new HashMap<>(8);
        for (String s : array) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // 只需要次数时
        // Collections.max(map.values());

        String maxStr = "";
        int maxCount = 0;
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            int count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                maxStr = entry.getKey();
            }
        }

        return new Object[]{maxStr, maxCount};
    }
}
