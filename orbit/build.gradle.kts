/*
 * Copyright (c) Ashley (uwuvern) <uwuvern@outlook.com> 2024
 *
 * This project is licensed under the Apache 2.0 license, see the LICENSE file in the root of the project for more information.
 *
 * If you wish to contact me you can do so at <uwuvern@outlook.com>.
 */

plugins {
    id("java")
}

group = "me.ashydev.quilt.orbit"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}