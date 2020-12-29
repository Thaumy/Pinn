plugins {
    java
    kotlin("jvm") version "1.4.10"
}

group = "thaumy.cn"
version = "1.0-SNAPSHOT"
val main_class = "thaumy.cn.PinnKt"

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = main_class
    }

    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

repositories {
    maven("https://mirrors.huaweicloud.com/repository/maven/")
    maven("https://jitpack.io")
    mavenCentral()
    jcenter()
}

dependencies {
    val miraiVersion = "2.0-M2"
    // 开发时使用 mirai-core-api，运行时提供 mirai-core
    api("net.mamoe:mirai-core-api:$miraiVersion")
    runtimeOnly("net.mamoe:mirai-core:$miraiVersion")

    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")

    testCompile("junit", "junit", "4.12")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}