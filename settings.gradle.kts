rootProject.name = "pensjon-etterlatte-libs"

plugins {
    kotlin("jvm") version "1.9.20" apply false
}

include(
    "common",
    "common-test",
    "ktor-client-auth",
)
