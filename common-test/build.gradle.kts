plugins {
    id("maven-publish")
}

dependencies {
    api(kotlin("stdlib"))
    api(kotlin("reflect"))

    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.4")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.13.4")
    api("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")

    implementation(project(":common"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("io.kotest:kotest-assertions-core:5.4.2")
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
                name.set("common-test")
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
