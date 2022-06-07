package org.luvx.offer.link;

import org.junit.jupiter.api.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.Utils;

class LinkTest {
    @Test
    void m05() {
        Offer05 exec = new Offer05();
        ListNode head = Utils.initLinked(1, 2, 3, 4, 5);
        exec.printListInverselyUsingIteration(head);
        exec.printListInverselyUsingRecursion(head);
    }
}