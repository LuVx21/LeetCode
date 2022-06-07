package org.luvx.offer.array;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.luvx.common.RunInReflect;

import com.alibaba.fastjson.JSON;

class ArrayTest {

    @Test
    void m51() {
        int[] numbers1 = {2, 1, 3, 1, 4};
        int[] numbers2 = {2, 4, 3, 1, 4};
        int[] numbers3 = {2, 4, 2, 1, 4};
        int[] numbers4 = {2, 1, 3, 0, 4};
        int[] numbers5 = {2, 1, 3, 5, 4};
        List<Object> duplicate = RunInReflect.exec(Offer51.class, "duplicate",
                numbers1,
                numbers2,
                numbers3,
                numbers4,
                numbers5
        );

        duplicate.stream()
                .map(JSON::toJSONString)
                .map(s -> 51 + ": " + s)
                .forEachOrdered(System.out::println);
    }
}