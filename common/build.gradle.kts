plugins {
    id("maven-publish")
}

dependencies {
    api(kotlin("stdlib"))
    api(kotlin("reflect"))

    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.4")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.13.4")
    api("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")

    implementation("io.ktor:ktor-client-core:2.1.1")
    implementation("io.ktor:ktor-client-logging-jvm:2.1.1")
    implementation("io.ktor:ktor-client-auth:2.1.1")
    implementation("io.ktor:ktor-serialization-jackson:2.1.1")
    implementation("io.ktor:ktor-client-content-negotiation:2.1.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("io.kotest:kotest-assertions-core:5.4.2")
    testImplementation("io.mockk:mockk:1.13.1")
    testImplementation("io.ktor:ktor-client-mock:2.1.1")
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
