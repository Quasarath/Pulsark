// settings.gradle.kts
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    // Apply the foojay-resolver plugin for automatic JDK management
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

// Define root project name
rootProject.name = "Pulsark"