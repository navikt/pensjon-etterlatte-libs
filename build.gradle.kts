import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import ca.cutterslade.gradle.analyze.AnalyzeDependenciesTask

plugins {
    kotlin("jvm") version "1.6.21"
    id("ca.cutterslade.analyze") version "1.8.1" apply true
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin"))
}

tasks {
    withType<Wrapper> {
        gradleVersion = "8.2"
    }

    withType<AnalyzeDependenciesTask> {
        warnUsedUndeclared = true
        warnUnusedDeclared = true
    }
}

allprojects {
    group = "no.nav.etterlatte"
    // version = blir håndtert av .github/workflows/release-*.yaml

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    tasks {
        withType<Test> {
            useJUnitPlatform()
        }

        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_16.toString()
        }
    }
}
