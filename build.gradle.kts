plugins {
    kotlin("jvm") version "2.3.20"
}

group = "io.github._4kleiber"
version = file("version.txt").readText().trim()

repositories {
    mavenCentral()
}

dependencies {
    // "api", not "implementation": kotlinx.html types (FlowContent, DIV, BUTTON, ...)
    // appear in every public function signature this library exposes, so the
    // dependency must be transitively visible to anything that compiles against us.
    api("org.jetbrains.kotlinx:kotlinx-html-jvm:0.12.0")

    testImplementation(kotlin("test"))
    testImplementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.12.0")
}

kotlin {
    jvmToolchain(21)
    explicitApi()
}

tasks.test {
    useJUnitPlatform()
}
