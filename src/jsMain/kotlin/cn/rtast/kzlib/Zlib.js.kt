/*
 * Copyright © 2025 RTAkland
 * Date: 2025/4/13 13:57
 * Open Source Under Apache-2.0 License
 * https://www.apache.org/licenses/LICENSE-2.0
 */

@file:Suppress("CLASSNAME")

package cn.rtast.kzlib

import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Int8Array
import org.khronos.webgl.Uint8Array

public fun ArrayBuffer.toByteArray(): ByteArray =
    Int8Array(this).unsafeCast<ByteArray>()

public fun ArrayBuffer.asByteArray(): ByteArray = toByteArray()

@JsModule("pako")
@JsNonModule
public external object Pako {
    public fun deflate(input: dynamic, options: dynamic = definedExternally): Uint8Array
    public fun inflate(input: dynamic, options: dynamic = definedExternally): Uint8Array
}

public actual fun ByteArray.zlibCompress(): ByteArray {
    val u8 = Pako.deflate(this, js("{raw:false}"))
    return u8.buffer.asByteArray()
}

public actual fun ByteArray.zlibDecompress(): ByteArray {
    val u8 = Pako.inflate(this, js("{raw:false}"))
    return u8.buffer.asByteArray()
}