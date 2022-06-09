package org.luvx.question.link;

import org.junit.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

public class SortTest {

    @Test
    public void sortTest() {
        final Sort exec = new Sort();
        ListNode h = LinkUtils.initLinked(1, 10, 3, 8, 5, 6, 7, 4, 9, 2);
        LinkUtils.printLink(
                exec.sort(h)
        );
        h = LinkUtils.initLinked(2, 9, 4, 7, 6, 5, 8, 3, 10, 1);
        LinkUtils.printLink(
                exec.sort(h)
        );
    }
}
