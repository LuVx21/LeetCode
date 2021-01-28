package org.luvx.leetcode

import kotlin.test.Test

private val log = mu.KotlinLogging.logger {}

class AliasKtTest {
    @Test
    fun test0() {
        val listNode1 = ListNodeKt(1)
        log.info { "val:${listNode1.`val`}" }
    }
}

