# kzlib

zlib/gzip for Kotlin Multiplatform project

It supports the following targets:

- jvm(1.8)
- mingwX64
- linuxX64
- linuxArm64
- macosX64
- macosArm64

# Get started

```kotlin

repositories {
    maven("https://repo.maven.rtast.cn/releases/")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation("cn.rtast.kzlib:kzlib:<version>")
        }
    }
}
```

> The latest version of kzlib can be found at https://next.pkg.rtast.cn/#/releases/cn/rtast/kzlib/kzlib

# Licenses

- This project is open source under [Apache-2.0](./LICENSE) license, that is:
    - You can directly use the functions provided by this project without any authorization
    - You can distribute, modify and derive the source code at will under the condition of **indicating the source
      copyright information**

