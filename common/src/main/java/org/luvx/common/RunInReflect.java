package org.luvx.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;

public class RunInReflect {

    public static List<Object> exec(String className, String methodName, Object... args) {
        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (Exception e) {
            return Collections.emptyList();
        }
        return exec(clazz, methodName, args);
    }

    public static List<Object> exec(Class<?> clazz, String methodName, Object... args) {
        List<Object> result = Lists.newArrayList();
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object o = constructor.newInstance();

            Method[] declaredMethods = clazz.getDeclaredMethods();
            Method method = Arrays.stream(declaredMethods)
                    .filter(m -> Objects.equals(methodName, m.getName()))
                    .filter(m -> args.length % m.getParameterCount() == 0)
                    .findFirst()
                    .orElseThrow();
            method.setAccessible(true);
            int parameterCount = method.getParameterCount();
            Object[][] objects = doArgs(parameterCount, args);
            for (Object[] arg : objects) {
                Object invoke = method.invoke(o, arg);
                if (invoke == null) {
                    invoke = arg;
                }
                result.add(invoke);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Object[][] doArgs(int cnt, Object... args) {
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
}
