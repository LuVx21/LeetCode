package org.luvx.leetcode.link;

import org.junit.jupiter.api.Test;
import org.luvx.leetcode.util.LinkUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilsTest {
    @Test
    public void main() {
        log.info("test:{}", "haha");
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = LinkUtils.initLinked(a);
        // TreeNode aa = Utils.sortedListToBST(head);
        // System.out.println(aa);
        // System.out.println(head.val);
        // printLink(head);
    }

    @Test
    void m1() {
        ListNode head = LinkUtils.initLinked3(1, 2, 3, 4, 5, 6, 7);
        LinkUtils.printLink1(head);
    }
}