import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import ca.cutterslade.gradle.analyze.AnalyzeDependenciesTask

plugins {
    `kotlin-dsl`
    id("ca.cutterslade.analyze") version "1.8.1" apply true
}

allprojects {
    group = "no.nav.etterlatte"
//    version = blir håndtert av .github/workflows/release-*.yaml

    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation(kotlin("gradle-plugin"))
}

tasks {
    withType<Wrapper> {
        gradleVersion = "7.3"
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    }

    withType<AnalyzeDependenciesTask> {
        warnUsedUndeclared = true
        warnUnusedDeclared = true
    }
}
