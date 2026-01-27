/*
 * Copyright © 2025 RTAkland
 * Date: 2025/4/12
 * Open Source Under Apache-2.0 License
 * https://www.apache.org/licenses/LICENSE-2.0
 */

package cn.rtast.kzlib

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.zip.Deflater
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream
import java.util.zip.Inflater

public actual fun ByteArray.gzipCompress(): ByteArray {
    val output = ByteArrayOutputStream(this.size)
    GZIPOutputStream(output).use { gzip -> gzip.write(this) }
    return output.toByteArray()
}

public actual fun ByteArray.gzipDecompress(): ByteArray =
    GZIPInputStream(ByteArrayInputStream(this)).use { it.readBytes() }

public actual fun ByteArray.zlibCompress(): ByteArray {
    val deflater = Deflater(Deflater.DEFAULT_COMPRESSION, true)
    val outputStream = ByteArrayOutputStream(this.size)
    val buffer = ByteArray(1024)
    deflater.setInput(this)
    deflater.finish()
    while (!deflater.finished()) {
        val length = deflater.deflate(buffer)
        outputStream.write(buffer, 0, length)
    }
    deflater.end()
    return outputStream.toByteArray()
}

public actual fun ByteArray.zlibDecompress(): ByteArray {
    val inflater = Inflater(true)
    val outputStream = ByteArrayOutputStream(this.size)
    val buffer = ByteArray(1024)
    inflater.setInput(this)
    while (!inflater.finished()) {
        val length = inflater.inflate(buffer)
        if (length > 0) outputStream.write(buffer, 0, length)
    }
    inflater.end()
    return outputStream.toByteArray()
}