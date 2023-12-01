import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import ca.cutterslade.gradle.analyze.AnalyzeDependenciesTask
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    `kotlin-dsl`
    alias(libs.plugins.cutterslade.analyze) apply true
}

group = "no.nav.etterlatte"

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

    withType<Test> {
        useJUnitPlatform()
        testLogging {
            events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        }
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    }
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    withType<AnalyzeDependenciesTask> {
        warnUsedUndeclared = true
        warnUnusedDeclared = true
    }
}
