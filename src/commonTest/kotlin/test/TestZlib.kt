/*
 * Copyright © 2026 RTAkland
 * Author: RTAkland
 * Date: 2026/1/27
 */


package test

import cn.rtast.kzlib.gzipCompress
import cn.rtast.kzlib.gzipDecompress
import cn.rtast.kzlib.zlibCompress
import cn.rtast.kzlib.zlibDecompress
import kotlin.test.Test

class TestZlib {
    private val raw = "Hello"

    @Test
    fun `test zlib`() {
        val zlibCompress = raw.encodeToByteArray().zlibCompress()
        println(zlibCompress)
        val zlibDecompress = zlibCompress.zlibDecompress()
        println(zlibDecompress.decodeToString())
    }

    @Test
    fun `test gzip`() {
        val gzipCompress = raw.encodeToByteArray().gzipCompress()
        println(gzipCompress)
        val gzipDecompress = gzipCompress.gzipDecompress()
        println(gzipDecompress.decodeToString())
    }
}