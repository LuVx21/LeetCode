package org.luvx.leetcode.java;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.luvx.coding.common.more.MoreRuns;

abstract class BaseTest {
    final String sample = "org.luvx.leetcode.java.%s._%d.Solution";

    protected void exec(int id, String methodName, Object... args) {
        String className = sample.formatted(level(), id);
        MoreRuns.run(className, methodName, args).stream()
                .map(JSON::toJSONString)
                .map(s -> STR."\{id}: \{s}")
                .forEachOrdered(System.out::println);
    }

    protected String level() {
        String simpleName = getClass().getSimpleName();
        simpleName = simpleName.substring(0, simpleName.lastIndexOf("Test"));
        return simpleName.toLowerCase();
    }

    // int      id;
    // String   methodName = "";
    // Object[] args       = null;
    //
    // @BeforeEach
    // void before() {
    //     id = 0;
    //     methodName = "";
    //     args = null;
    // }
    //
    // @AfterEach
    // void tearDown() {
    //     System.out.println("haha");
    //     // exec(id, methodName, args);
    // }
}

