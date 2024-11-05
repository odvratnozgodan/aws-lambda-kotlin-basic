plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.21"
    `java-library`
    id("com.gradleup.shadow") version "8.3.5"
}

group = "solutions.deliverit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.3")
    implementation("com.gradleup.shadow:shadow-gradle-plugin:8.3.5")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}