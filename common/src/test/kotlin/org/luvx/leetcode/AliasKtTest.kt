package org.luvx.leetcode

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.test.Test

private val log = KotlinLogging.logger {}

class AliasKtTest {
    @Test
    fun test0() {
        val listNode1 = ListNodeKt(1)
        log.info { "val:${listNode1.`val`}" }
    }
}

