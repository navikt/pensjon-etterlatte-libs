plugins {
    id("maven-publish")
    id("etterlatte")
}

dependencies {
    api(kotlin("stdlib"))
    api(kotlin("reflect"))

    api(libs.jackson.datatypejsr310)
    api(libs.jackson.datatypejdk8)
    api(libs.jackson.modulekotlin)

    testImplementation(libs.test.jupiter.api)
    testImplementation(libs.test.kotest.assertionscore)
    testImplementation(libs.test.mockk)
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
                name.set("common")
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
