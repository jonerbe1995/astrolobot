plugins {
    alias(libs.plugins.kotlinMultiplatform)
    id("com.android.library")
}

kotlin {
    androidTarget()
    
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
    namespace = "com.jerbeware.astrolobot"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}