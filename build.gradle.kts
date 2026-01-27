import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform") version "2.2.21"
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
    jvm { compilerOptions.jvmTarget = JvmTarget.JVM_1_8 }
    js(IR) {
        nodejs()
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
    }

    sourceSets {
        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        jsMain.dependencies {
            implementation(npm("pako", "2.1.0"))
        }
    }
}

publishing {
    repositories {
        mavenLocal()
        maven("https://repo.maven.rtast.cn/releases/") {
            name = "RTAST"
            credentials {
                username = "RTAkland"
                password = System.getenv("PUBLISH_TOKEN")
            }
        }
    }
}