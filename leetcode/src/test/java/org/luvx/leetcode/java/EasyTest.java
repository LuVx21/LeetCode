package org.luvx.leetcode.java;

import org.junit.jupiter.api.Test;
import org.luvx.leetcode.tree.Node;

public class EasyTest extends BaseTest {
    @Test
    void m344() {
        char[] array = {'h', 'e', 'l', 'l', 'o'};
        char[] array1 = {'H', 'a', 'n', 'n', 'a', 'h'};
        exec(344, "reverseString", array, array1);
    }

    @Test
    void m415() {
        exec(415, "addStrings1",
                "456", "902",
                "456", "9902"
        );
    }

    @Test
    void m559() {
        Node root = Node.of(1,
                Node.of(3, Node.of(5, Node.of(7)), Node.of(6)),
                Node.of(2),
                Node.of(4)
        );
        exec(559, "maxDepth", root);
    }
}
