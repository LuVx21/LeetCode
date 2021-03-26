package org.luvx.leetcode.java.medium._916;

import org.luvx.leetcode.out
import kotlin.test.Test

class SolutionTest {

    @Test
    fun wordSubsets() {
        val A = arrayOf("amazon", "apple", "facebook", "google", "leetcode")
        val list = listOf(
            // "facebook","google","leetcode"
            // "apple","google","leetcode"
            // "facebook","google"
            // "google","leetcode"
            // "facebook","leetcode"
            arrayOf("e", "o"),
            arrayOf("l", "e"),
            arrayOf("e", "oo"),
            arrayOf("lo", "eo"),
            arrayOf("ec", "oc", "ceo")
        )
        val exec = Solution();
        for (B in list) {
            exec.wordSubsets(A, B).out();
        }
    }
}