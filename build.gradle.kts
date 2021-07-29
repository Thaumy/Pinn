plugins {
    kotlin("jvm") version "1.5.0"
}

group = "Thaumy"
version = "2.0"

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "Pinn.AppKt"
    }

    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(fileTree("src/main/resources"))

    api("net.mamoe:mirai-core-api:2.7-M2")//dev
    runtimeOnly("net.mamoe:mirai-core:2.7-M2")//runtime
    implementation("com.alibaba:fastjson:1.2.76")
    implementation("mysql:mysql-connector-java:8.0.26")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}