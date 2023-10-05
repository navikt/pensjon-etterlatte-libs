rootProject.name = "no.nav.etterlatte"

plugins {
    kotlin("jvm") version "1.8.22" apply false
}

include(
    "common",
    "common-test",
    "ktor-client-auth",
)
