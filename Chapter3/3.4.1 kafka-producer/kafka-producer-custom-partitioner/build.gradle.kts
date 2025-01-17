plugins {
    id("java")
    kotlin("jvm") version "1.7.22"
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.kafka:kafka-clients:3.6.1")
    implementation("org.slf4j:slf4j-simple:1.7.30")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
kotlin {
    jvmToolchain(17)
}