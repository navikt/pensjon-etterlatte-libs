import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import ca.cutterslade.gradle.analyze.AnalyzeDependenciesTask

plugins {
    `kotlin-dsl`
    alias(libs.plugins.cutterslade.analyze) apply true
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin"))

    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
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

    repositories {
        mavenCentral()
    }

    tasks {
        withType<Test> {
            useJUnitPlatform()
        }

        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
        }
        java {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }
}
