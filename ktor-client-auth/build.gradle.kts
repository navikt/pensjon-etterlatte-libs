plugins {
    id("maven-publish")
}

dependencies {
    api(kotlin("stdlib"))
    api(kotlin("reflect"))

    api("io.ktor:ktor-client-okhttp:2.1.1")
    api("io.ktor:ktor-client-core:2.1.1")
    api("io.ktor:ktor-client-auth:2.1.1")
    api("io.ktor:ktor-client-content-negotiation:2.1.1")
    api("io.ktor:ktor-serialization-jackson:2.1.1")
    api("io.ktor:ktor-client-logging-jvm:2.1.1")

    api("no.nav.security:token-client-core:2.1.2")
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
                name.set("ktor-client-auth")
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
