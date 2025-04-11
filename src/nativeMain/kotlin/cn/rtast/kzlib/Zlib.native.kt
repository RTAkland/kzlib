/*
 * Copyright © 2025 RTAkland
 * Date: 2025/4/12
 * Open Source Under Apache-2.0 License
 * https://www.apache.org/licenses/LICENSE-2.0
 */

@file:OptIn(ExperimentalForeignApi::class)

package cn.rtast.kzlib

import kotlinx.cinterop.*
import platform.zlib.*

public actual fun ByteArray.zlibDecompress(): ByteArray = memScoped {
    val stream = alloc<z_stream>()
    stream.zalloc = null
    stream.zfree = null
    stream.opaque = null
    check(inflateInit_(stream.ptr, ZLIB_VERSION, sizeOf<z_stream>().toInt()) == Z_OK) {
        "inflateInit_ failed"
    }
    stream.next_in = this@zlibDecompress.refTo(0).getPointer(this).reinterpret()
    stream.avail_in = this@zlibDecompress.size.toUInt()
    val output = mutableListOf<Byte>()
    val bufferSize = 4096
    val tempBuffer = ByteArray(bufferSize)
    do {
        stream.next_out = tempBuffer.refTo(0).getPointer(this).reinterpret()
        stream.avail_out = bufferSize.toUInt()
        val result = inflate(stream.ptr, Z_NO_FLUSH)
        check(result == Z_OK || result == Z_STREAM_END) { "inflate error: $result" }
        val bytesDecompressed = bufferSize - stream.avail_out.toInt()
        output.addAll(tempBuffer.take(bytesDecompressed))
        if (result == Z_STREAM_END) break
    } while (stream.avail_out == 0u)
    inflateEnd(stream.ptr)
    return output.toByteArray()
}

public actual fun ByteArray.zlibCompress(): ByteArray = memScoped {
    val stream = alloc<z_stream>()
    stream.zalloc = null
    stream.zfree = null
    stream.opaque = null
    deflateInit_(stream.ptr, Z_DEFAULT_COMPRESSION, ZLIB_VERSION, sizeOf<z_stream>().toInt())
    stream.next_in = this@zlibCompress.refTo(0).getPointer(this).reinterpret()
    stream.avail_in = this@zlibCompress.size.toUInt()
    val buffer = ByteArray(1024)
    val output = mutableListOf<Byte>()
    do {
        stream.next_out = buffer.refTo(0).getPointer(this).reinterpret()
        stream.avail_out = buffer.size.toUInt()
        deflate(stream.ptr, Z_FINISH)
        val have = buffer.size - stream.avail_out.toInt()
        output.addAll(buffer.take(have))
    } while (stream.avail_out == 0u)
    deflateEnd(stream.ptr)
    return output.toByteArray()
}