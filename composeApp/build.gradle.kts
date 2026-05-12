plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.androidApplication)
}

kotlin {
    androidTarget()
    
    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared"))
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(libs.kotlinx.datetime)
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
}

implementation(project(":shared"))