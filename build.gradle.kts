@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform") version "2.1.20"
    id("maven-publish")
}

repositories {
    mavenCentral()
}

val libVersion: String by extra

group = "cn.rtast.kzlib"
version = libVersion

kotlin {
    withSourcesJar()
    explicitApi()

    mingwX64()
    macosArm64()
    macosX64()
    linuxX64()
    linuxArm64()
    jvm {
        compilerOptions.jvmTarget = JvmTarget.JVM_1_8
    }
    watchosArm32()
    watchosArm64()
    watchosDeviceArm64()
    watchosSimulatorArm64()
    watchosX64()
    tvosArm64()
    tvosSimulatorArm64()
    tvosX64()
    iosArm64()
    iosX64()
    iosSimulatorArm64()
    js(IR) {
        nodejs()
        browser()
    }

    sourceSets {
        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        jsMain.dependencies {
            api(npm("pako", "2.1.0"))
        }
    }
}

publishing {
    repositories {
        maven("https://maven.rtast.cn/releases/") {
            credentials {
                username = "RTAkland"
                password = System.getenv("PUBLISH_TOKEN")
            }
        }
    }
}