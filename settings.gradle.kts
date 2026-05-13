rootProject.name = "astrolobot"

// These lines tell Gradle to look for the sub-folders
include(":composeApp")
include(":shared")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    // This allows you to use the libs.versions.toml catalog
    versionCatalogs {
        create("libs") {
            // from(files("gradle/libs.versions.toml"))
        }
    }
}