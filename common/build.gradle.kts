import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("maven-publish")
}

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib"))
    api(kotlin("reflect"))

    api(Jackson.DatatypeJsr310)
    api(Jackson.DatatypeJdk8)
    api(Jackson.ModuleKotlin)

    implementation(Ktor.ClientCore)
    implementation(Ktor.ClientLoggingJvm)
    implementation(Ktor.ClientAuth)
    implementation(Ktor.ClientJackson)

    testImplementation(Jupiter.Api)
    testImplementation(Jupiter.Params)
    testRuntimeOnly(Jupiter.Engine)
    testImplementation(Kotest.AssertionsCore)
    testImplementation(MockK.MockK)
    testImplementation(Ktor.ClientMock)
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "16"
    }
}

publishing {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/navikt/pensjon-etterlatte-libs")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("mavenJava") {

            pom {
                groupId = "com.github.navikt.etterlatte.libs"
                artifactId = "etterlatte-libs-common"

                name.set("pensjon-etterlatte-libs")
                url.set("https://github.com/navikt/pensjon-etterlatte-libs")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                scm {
                    connection.set("scm:git:https://github.com/navikt/pensjon-etterlatte-libs.git")
                    developerConnection.set("scm:git:https://github.com/navikt/pensjon-etterlatte-libs.git")
                    url.set("https://github.com/navikt/pensjon-etterlatte-libs")
                }
            }
            from(components["java"])
        }
    }
}
