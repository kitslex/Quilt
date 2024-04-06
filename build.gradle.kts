/*
 * Copyright (c) Ashley (uwuvern) <uwuvern@outlook.com> 2024
 *
 * This project is licensed under the Apache 2.0 license, see the LICENSE file in the root of the project for more information.
 *
 * If you wish to contact me you can do so at <uwuvern@outlook.com>.
 */

plugins {
    id("java")

    `maven-publish`
}

allprojects {
    group = properties["group"] as String
    version = properties["version"] as String
}

subprojects {
    apply {
        plugin("java")

        plugin("maven-publish")
    }

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }

    val testImplementation by configurations
    val implementation by configurations

    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.10.2"))
        testImplementation("org.junit.jupiter:junit-jupiter")
        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testImplementation("org.junit.jupiter:junit-jupiter-engine")
    }

    tasks {
        named("build") {
            dependsOn("shadowJar")
        }
    }

    tasks {
        withType<JavaCompile> {
            sourceCompatibility = project.properties["java"] as String
            targetCompatibility = project.properties["java"] as String

            options.encoding = "UTF-8"
        }
    }


    tasks {
        test {
            useJUnitPlatform()
        }
    }
}