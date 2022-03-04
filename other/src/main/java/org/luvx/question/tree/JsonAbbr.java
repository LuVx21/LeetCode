package org.luvx.question.tree;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 在某个特定应用场景中，我们有一个从JSON获取的内容，比如：
 * m = { "a": 1, "b": { "c": 2, "d": [3,4] } }
 * 现在需要把这个层级的结构做展开，只保留一层key/value结构。对于上述输入，需要得到的结构是：
 * o = {"a": 1, "b.c": 2, "b.d": [3,4] }
 * 也就是说，原来需要通过 m["b"]["c"] 访问的值，在展开后可以通过 o["b.c"] 访问。
 * 请实现这个“层级结构展开”的代码。
 * 输入：任意JSON（或者map/dict）
 * 输出：展开后的JSON（或者map/dict）
 */
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
     *         },
     *         "k":[{
     *             "l": 8,
     *             "m": 9
     *         },{
     *             "n": 10
     *         }]
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
     *          "f.h.i": 6,
     *          "f.h.j": 7,
     *          "k.0.l": 8,
     *          "k.1.m": 9
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
            } else if (value instanceof List) {
                List temp = (List) value;
                if (!temp.isEmpty() && temp.get(0) instanceof Map) {
                    List<Map<String, Object>> list = (List<Map<String, Object>>) value;
                    for (int i = 0; i < list.size(); i++) {
                        Map<String, Object> innerResultMap = jsonAbbr(list.get(i));
                        for (Entry<String, Object> entry1 : innerResultMap.entrySet()) {
                            String innerKey = key + "." + i + "." + entry1.getKey();
                            result.put(innerKey, entry1.getValue());
                        }
                    }
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
        Queue<Entry<String, Object>> queue = new LinkedList<>(map.entrySet());
        while (!queue.isEmpty()) {
            Entry<String, Object> parent = queue.poll();
            Object value = parent.getValue();
            if (value instanceof Map) {
                ((Map<String, Object>) value).forEach((k, v) -> {
                    queue.offer(new SimpleEntry<>(parent.getKey() + "." + k, v));
                });
            } else if (value instanceof List) {
                List temp = (List) value;
                if (!temp.isEmpty() && temp.get(0) instanceof Map) {
                    List<Map<String, Object>> list = (List<Map<String, Object>>) value;
                    for (int i = 0; i < list.size(); i++) {
                        int finalI = i;
                        list.get(i).forEach((k, v) -> {
                            queue.offer(new SimpleEntry<>(parent.getKey() + "." + finalI + "." + k, v));
                        });
                    }
                }
            } else {
                result.put(parent.getKey(), value);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        JsonAbbr exec = new JsonAbbr();

        Map<String, Object> map = Map.of(
                "a", 1,
                "b", 2,
                "c", Map.of(
                        "d", 3,
                        "e", 4),
                "f", Map.of(
                        "g", 5,
                        "h", Map.of(
                                "i", 6,
                                "j", 7)),
                "k", List.of(Map.of(
                        "l", 8,
                        "m", 9), Map.of(
                        "n", 10))
        );

        Map<String, Object> result = exec.jsonAbbr1(map);
        result.entrySet().stream().sorted(Entry.comparingByKey()).forEach(System.out::println);
    }
}
