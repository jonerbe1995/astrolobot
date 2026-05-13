plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget {
        // Use compilerOptions for Kotlin 2.0+ 
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    sourceSets {
        // This is the correct scope for shared logic
        commonMain.dependencies {
            implementation(project(":shared")) // Links AstrologyEngine and RoastRepo
            
            // Other dependencies from your libs.versions.toml
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.kotlinx.datetime)
            implementation(libs.androidx.activity.compose)
        }
    }
}

android {
    namespace = "com.jerbeware.astrolobot"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.jerbeware.astrolobot"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0-MVP"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
