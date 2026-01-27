/*
 * Copyright © 2025 RTAkland
 * Date: 2025/4/12
 * Open Source Under Apache-2.0 License
 * https://www.apache.org/licenses/LICENSE-2.0
 */


@file:OptIn(ExperimentalUnsignedTypes::class)

package cn.rtast.kzlib

public expect fun ByteArray.gzipCompress(): ByteArray

public expect fun ByteArray.gzipDecompress(): ByteArray

public expect fun ByteArray.zlibCompress(): ByteArray

public expect fun ByteArray.zlibDecompress(): ByteArray

public fun UByteArray.zlibCompress(): ByteArray = this.toByteArray().zlibCompress()

public fun UByteArray.zlibDecompress(): ByteArray = this.toByteArray().zlibDecompress()