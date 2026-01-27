/*
 * Copyright © 2025 RTAkland
 * Date: 2025/4/13 13:57
 * Open Source Under Apache-2.0 License
 * https://www.apache.org/licenses/LICENSE-2.0
 */

@file:Suppress("CLASSNAME")

package cn.rtast.kzlib

import org.khronos.webgl.Int8Array
import org.khronos.webgl.Uint8Array

public fun Uint8Array.toByteArray(): ByteArray =
    Int8Array(buffer, byteOffset, byteLength).unsafeCast<ByteArray>()

public fun ByteArray.toUint8Array(): Uint8Array {
    val i8a = unsafeCast<Int8Array>()
    return Uint8Array(i8a.buffer, i8a.byteOffset, i8a.byteLength)
}

private fun MutableList<Uint8Array>.merge(): ByteArray {
    val totalLength = this.sumOf { it.length }
    val result = ByteArray(totalLength)
    var offset = 0
    this.forEach { chunk ->
        chunk.toByteArray().copyInto(result, offset)
        offset += chunk.length
    }
    return result
}

public actual fun ByteArray.gzipCompress(): ByteArray {
    val deflate = Deflate(level = ZLevel.DEFAULT_COMPRESSION, windowBits = 15 + 16)
    val compressedData = mutableListOf<Uint8Array>()
    deflate.onData = { chunk -> compressedData.add(chunk) }
    deflate.onEnd = {}
    deflate.push(this.toUint8Array(), ZFlushMode.FINISH)
    return compressedData.merge()
}

public actual fun ByteArray.gzipDecompress(): ByteArray {
    val inflate = Inflate(windowBits = 15 + 32)
    val decompressedData = mutableListOf<Uint8Array>()
    inflate.onData = { chunk -> decompressedData.add(chunk) }
    inflate.onEnd = {}
    inflate.push(this.toUint8Array(), ZFlushMode.FINISH)
    return decompressedData.merge()
}

public actual fun ByteArray.zlibCompress(): ByteArray {
    val deflate = Deflate(level = ZLevel.DEFAULT_COMPRESSION, windowBits = 15)
    val compressedData = mutableListOf<Uint8Array>()
    deflate.onData = { chunk -> compressedData.add(chunk) }
    deflate.onEnd = {}
    deflate.push(this.toUint8Array(), ZFlushMode.FINISH)
    return compressedData.merge()
}

public actual fun ByteArray.zlibDecompress(): ByteArray {
    val inflate = Inflate(windowBits = 15)
    val decompressedData = mutableListOf<Uint8Array>()
    inflate.onData = { chunk -> decompressedData.add(chunk) }
    inflate.onEnd = {}
    inflate.push(this.toUint8Array(), ZFlushMode.FINISH)
    return decompressedData.merge()
}
