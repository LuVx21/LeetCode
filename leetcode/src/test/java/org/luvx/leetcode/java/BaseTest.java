package org.luvx.leetcode.java;

import org.luvx.common.RunInReflect;

import com.alibaba.fastjson.JSON;

public abstract class BaseTest {
    final String sample = "org.luvx.leetcode.java.%s._%d.Solution";

    protected void exec(int id, String methodName, Object... args) {
        String className = sample.formatted(level(), id);
        RunInReflect.exec(className, methodName, args).stream()
                .map(JSON::toJSONString)
                .map(s -> id + ": " + s)
                .forEachOrdered(System.out::println);
    }

    protected String level() {
        String simpleName = getClass().getSimpleName();
        simpleName = simpleName.substring(0, simpleName.lastIndexOf("Test"));
        return simpleName.toLowerCase();
    }
}

