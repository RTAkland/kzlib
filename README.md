# KZlib

Zlib for Kotlin Multiplatform project

It supported the following targets:

- watchosArm32
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

- Kotlin > 2.1.20(maybe earlier version can also work, but I have not tested it.)

# Add dependencies

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

# Licenses

- This project is open source under [Apache-2.0](./LICENSE) license, that is:
    - You can directly use the functions provided by this project without any authorization
    - You can distribute, modify and derive the source code at will under the condition of **indicating the source
      copyright information**

# Special thanks

<div>

<img src="https://resources.jetbrains.com/storage/products/company/brand/logos/jetbrains.png" alt="JetBrainsIcon" width="128">

<a href="https://www.jetbrains.com/opensource/"><code>JetBrains Open Source</code></a> provided the powerful IDE support

</div>

# 中文版本

这是一个在Kotlin multiplatform 工作的zlib库

并且支持以下平台

- watchosArm32
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

# 要求

- Kotlin 版本大于等于2.1.20(更低的版本可能也行, 我没测试)

# 添加依赖

```kotlin

repositories {
    // 添加maven仓库
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

> 最新版本可以在这里找到 https://repo.maven.rtast.cn/#/releases/cn/rtast/kzlib/kzlib

# 开源

- 本项目以[Apache-2.0](./LICENSE)许可开源, 即:
    - 你可以直接使用该项目提供的功能, 无需任何授权
    - 你可以在**注明来源版权信息**的情况下对源代码进行任意分发和修改以及衍生

# 鸣谢

<div>

<img src="https://resources.jetbrains.com/storage/products/company/brand/logos/jetbrains.png" alt="JetBrainsIcon" width="128">

<a href="https://www.jetbrains.com/opensource/"><code>JetBrains Open Source</code></a> 提供的强大IDE支持

</div>