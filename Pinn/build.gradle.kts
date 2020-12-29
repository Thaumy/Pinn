/*
import java.util.*
import java.text.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.*
*/
plugins {
    java
    kotlin("jvm") version "1.4.10"
    //application
    //id("com.github.johnrengelman.shadow") version "5.2.0"
}
/*
apply(plugin = "com.github.johnrengelman.shadow")
apply(plugin = "java")
*/
group = "thaumy.cn"
version = "1.0-SNAPSHOT"
val main_class = "thaumy.cn.PinnKt"

/*
application {
    mainClassName = main_class
}*/

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = main_class
    }
    // To add all of the dependencies
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
    //compileOnly("com.github.jengelman.gradle.plugins:shadow:5.2.0")
    implementation(kotlin("stdlib"))
    //implementation("com.jcabi:jcabi-manifests:0.7.5")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    //implementation(fileTree("src/main/resources/libs"))
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
/*
val shadowJar: ShadowJar by tasks
shadowJar.apply {
    manifest {
        attributes["Main-Class"] = main_class
    }
}*/