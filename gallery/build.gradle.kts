plugins {
    kotlin("jvm")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":"))
    implementation("io.ktor:ktor-server-core:3.4.2")
    implementation("io.ktor:ktor-server-netty:3.4.2")
    implementation("io.ktor:ktor-server-html-builder:3.4.2")
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("io.github._4kleiber.bootstrap.gallery.MainKt")
}
