
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
