# KZlib

Zlib for Kotlin Multiplatform project

It supported the following targets:

- watchosArm32)
- watchosArm64
- watchosDeviceArm64
- watchosSimulatorArm64
- watchosX64
- mingwX64
- macosArm64
- macosX64
- linuxX64
- linuxArm64
- jvm(JDK 1.8)

# Requirements

- Kotlin > 2.1.20

# Apply plugin

```kotlin

repositories {
    // Add the repository
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

> The latest version of kzlib can be found at https://repo.maven.rtast.cn/#/releases/cn/rtast/kzlib/kzlib