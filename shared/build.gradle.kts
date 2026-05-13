plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        // Use compilerOptions for Kotlin 2.0+ 
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    } 
    // iOS Target Configuration
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.datetime)
        }
    }
}

android {
    namespace = "com.jerbeware.astrolobot.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}