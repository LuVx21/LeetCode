package org.luvx.question.tree;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

public class JsonAbbr {
    /**
     * <pre>
     *     {
     *         "a": 1,
     *         "b": 2,
     *         "c": {
     *             "d": 3,
     *             "e": 4,
     *         },
     *         "f": {
     *             "g": 5,
     *             "h": {
     *                 "i": 6,
     *                  "j": 7
     *             }
     *         }
     *     }
     * </pre>
     * 处理成只有一级的 json
     * <pre>
     *     {
     *          "a": 1,
     *          "b": 2,
     *          "c.d": 3,
     *          "c.e": 4,
     *          "f.g": 5,
     *          "f.h.i": 6
     *          "f.h.j": 7
     *     }
     * </pre>
     * 递归实现
     */
    public Map<String, Object> jsonAbbr(Map<String, Object> map) {
        Map<String, Object> result = Maps.newHashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Map) {
                Map<String, Object> innerResultMap = jsonAbbr((Map<String, Object>) value);
                for (Entry<String, Object> entry1 : innerResultMap.entrySet()) {
                    String innerKey = key + "." + entry1.getKey();
                    result.put(innerKey, entry1.getValue());
                }
            } else {
                result.put(key, value);
            }
        }

        return result;
    }

    /**
     * 循环: N 叉树 层次遍历
     * <pre>
     * </pre>
     */
    public Map<String, Object> jsonAbbr1(Map<String, Object> map) {
        Map<String, Object> result = Maps.newHashMap();
        Queue<Entry<String, Object>> queue = new LinkedList<>();
        for (Entry<String, Object> entry : map.entrySet()) {
            queue.offer(entry);
        }
        while (!queue.isEmpty()) {
            Entry<String, Object> parent = queue.poll();
            Object value = parent.getValue();
            if (value instanceof Map) {
                ((Map<String, Object>) value).forEach((k, v) -> {
                    queue.offer(new SimpleEntry<>(parent.getKey() + "." + k, v));
                });
            } else {
                result.put(parent.getKey(), value);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        JsonAbbr exec = new JsonAbbr();

        Map<String, Object> map = Map.of("a", "1",
                "b", 2,
                "c", Map.of("d", 3,
                        "e", 4),
                "f", Map.of("g", 5,
                        "h", Map.of("i", 6,
                                "j", 7)));

        Map<String, Object> result = exec.jsonAbbr1(map);
        System.out.println(JSON.toJSONString(result, true));
    }
}
