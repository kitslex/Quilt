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