/*
 * Copyright © 2025 RTAkland
 * Date: 2025/4/12
 * Open Source Under Apache-2.0 License
 * https://www.apache.org/licenses/LICENSE-2.0
 */


@file:OptIn(ExperimentalUnsignedTypes::class)
@file:Suppress("unused")

package cn.rtast.kzlib

public expect fun ByteArray.zlibCompress(): ByteArray

public expect fun ByteArray.zlibDecompress(): ByteArray

public fun UByteArray.zlibCompress() = this.toByteArray().zlibCompress()

public fun UByteArray.zlibDecompress() = this.toByteArray().zlibDecompress()