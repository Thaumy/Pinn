plugins {
    java
    kotlin("jvm") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://mirrors.huaweicloud.com/repository/maven/")
    jcenter()
    maven("https://jitpack.io")
    mavenCentral()
}

dependencies {
    val miraiVersion = "2.0-M2"

    // 开发时使用 mirai-core-api，运行时提供 mirai-core
    api("net.mamoe:mirai-core-api:$miraiVersion")
    runtimeOnly("net.mamoe:mirai-core:$miraiVersion")
    //runtimeOnly("net.mamoe:mirai-login-solver-selenium:1.0-dev-6")

    implementation(kotlin("stdlib"))
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
