package org.luvx.leetcode.java;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public abstract class BaseTest {
    final String sample = "org.luvx.leetcode.java.%s._%d.Solution";

    protected void exec(int id, String methodName, Object... args) {
        String className = sample.formatted(level(), id);
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object o = constructor.newInstance();

            Method[] declaredMethods = clazz.getDeclaredMethods();
            Method method = Arrays.stream(declaredMethods)
                    .filter(m -> Objects.equals(methodName, m.getName()))
                    .findFirst()
                    .orElseThrow();
            method.setAccessible(true);
            int parameterCount = method.getParameterCount();
            Object[][] objects = doArgs(parameterCount, args);
            for (Object[] arg : objects) {
                Object invoke = method.invoke(o, arg);
                String s = JSON.toJSONString(invoke);
                System.out.println(id + ": " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object[][] doArgs(int cnt, Object... args) {
        if (cnt == 0 || ArrayUtils.isEmpty(args)) {
            return new Object[0][0];
        }
        if (args.length % cnt != 0) {
            throw new RuntimeException("参数数量不匹配");
        }
        Object[][] result = new Object[args.length / cnt][cnt];
        for (int i = 0; i < args.length; i++) {
            result[i / cnt][i % cnt] = args[i];
        }
        return result;
    }

    protected String level() {
        String simpleName = getClass().getSimpleName();
        simpleName = simpleName.substring(0, simpleName.lastIndexOf("Test"));
        return simpleName.toLowerCase();
    }
}

