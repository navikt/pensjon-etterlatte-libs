plugins {
    id("maven-publish")
}

dependencies {
    api(kotlin("stdlib"))
    api(kotlin("reflect"))

    ktor("client-okhttp")
    ktor("client-core")
    ktor("client-logging-jvm")
    ktor("client-auth")
    ktor("client-jackson")

    api("no.nav.security:token-client-core:1.3.3")
}

fun DependencyHandler.ktor(module: String){
    when(module){
        "client-jackson" -> api("io.ktor:ktor-$module:1.6.1")
        else -> api("io.ktor:ktor-$module:1.6.1") {
            exclude("org.jetbrains.kotlin:kotlin-reflect")
        }
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
                name.set("ktorclient-auth-clientcredentials")
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
