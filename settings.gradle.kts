rootProject.name = "no.nav.etterlatte"

plugins {
    kotlin("jvm") version "1.9.10" apply false
}

include(
    "common",
    "common-test",
    "ktor-client-auth",
)
