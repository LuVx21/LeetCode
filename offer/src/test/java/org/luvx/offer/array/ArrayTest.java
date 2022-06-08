package org.luvx.offer.array;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class ArrayTest {

    @Test
    void m51() {
        int[] numbers1 = {2, 1, 3, 1, 4};
        int[] numbers2 = {2, 4, 3, 1, 4};
        int[] numbers3 = {2, 4, 2, 1, 4};
        int[] numbers4 = {2, 1, 3, 0, 4};
        int[] numbers5 = {2, 1, 3, 5, 4};

        Offer51 exec = new Offer51();
        Stream.of(
                        numbers1, numbers2, numbers3,
                        numbers4, numbers5
                )
                .map(exec::duplicate)
                .forEachOrdered(System.out::println);
    }
}