// pulsark/build.gradle.kts
plugins {
    `java-library` // ✅ Use `java-library` instead of `application`
}

repositories {
    mavenCentral()
}

dependencies {
    // Add any dependencies your library needs
    implementation("com.google.guava:guava:32.0.0-jre")

    val gsonVersion = "2.8.9"
    val slf4jVersion = "2.0.16"
    val jomlVersion = "1.10.8"
    val lwjglVersion = "3.3.4"

    // Gson
    implementation("com.google.code.gson:gson:$gsonVersion")

    // slf4j
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")

    // JOML
    implementation("org.joml:joml:$jomlVersion")

    // LWJGL
    implementation(platform("org.lwjgl:lwjgl-bom:$lwjglVersion"))
    implementation("org.lwjgl:lwjgl")
    implementation("org.lwjgl:lwjgl-glfw")
    implementation("org.lwjgl:lwjgl-opengl")
    implementation("org.lwjgl:lwjgl-openal")
    implementation("org.lwjgl:lwjgl-stb")
}

// Set Java version
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.jar {
    archiveBaseName.set("Pulsark")
    archiveVersion.set(project.version.toString())
    manifest {
        attributes(
            "Implementation-Version" to project.version
        )
    }
}