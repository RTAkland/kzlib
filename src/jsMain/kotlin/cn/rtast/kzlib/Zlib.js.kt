/*
 * Copyright © 2025 RTAkland
 * Date: 2025/4/13 13:57
 * Open Source Under Apache-2.0 License
 * https://www.apache.org/licenses/LICENSE-2.0
 */

@file:Suppress("CLASSNAME")

package cn.rtast.kzlib

@JsModule("pako")
@JsNonModule
public external object pako {
    public fun deflate(input: dynamic): dynamic
    public fun inflate(input: dynamic): dynamic
}

public actual fun ByteArray.zlibCompress(): ByteArray {
    return pako.deflate(this)
}

public actual fun ByteArray.zlibDecompress(): ByteArray {
    return pako.inflate(this)
}