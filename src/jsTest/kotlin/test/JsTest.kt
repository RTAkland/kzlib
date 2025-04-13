/*
 * Copyright © 2025 RTAkland
 * Date: 2025/4/13 13:59
 * Open Source Under Apache-2.0 License
 * https://www.apache.org/licenses/LICENSE-2.0
 */


package test

import cn.rtast.kzlib.zlibCompress
import cn.rtast.kzlib.zlibDecompress
import kotlin.test.Test

class JsTest {
    @Test
    fun `Test Js ZLib`() {
        val sample = "111".encodeToByteArray()
        println(sample.zlibCompress().zlibDecompress().decodeToString())
    }
}