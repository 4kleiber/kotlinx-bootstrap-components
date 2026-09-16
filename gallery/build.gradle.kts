plugins {
    kotlin("jvm")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":"))
    implementation("io.ktor:ktor-server-core:3.6.0")
    implementation("io.ktor:ktor-server-netty:3.6.0")
    implementation("io.ktor:ktor-server-html-builder:3.6.0")
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("io.github._4kleiber.bootstrap.gallery.MainKt")
}
