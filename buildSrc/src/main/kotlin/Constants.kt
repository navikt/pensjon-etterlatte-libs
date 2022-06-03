object NavFelles {
    const val TokenClientCore = "no.nav.security:token-client-core:1.3.3"
}

object Ktor {
    private const val version = "1.6.1"

    const val ClientCore = "io.ktor:ktor-client-core:$version"
    const val ClientLoggingJvm = "io.ktor:ktor-client-logging-jvm:$version"
    const val ClientAuth = "io.ktor:ktor-client-auth:$version"
    const val ClientJackson = "io.ktor:ktor-client-jackson:$version"
    const val ClientMock = "io.ktor:ktor-client-mock:$version"
}

object Jackson {
    private const val version = "2.12.1"

    const val DatatypeJsr310 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$version"
    const val DatatypeJdk8 = "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$version"
    const val ModuleKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:$version"
}

object Jupiter {
    private const val version = "5.7.2"

    const val Api = "org.junit.jupiter:junit-jupiter-api:$version"
    const val Params = "org.junit.jupiter:junit-jupiter-params:$version"
    const val Engine = "org.junit.jupiter:junit-jupiter-engine:$version"
}

object MockK {
    const val MockK = "io.mockk:mockk:1.12.0"
}

object Kotest {
    private const val version = "4.6.3"

    const val AssertionsCore = "io.kotest:kotest-assertions-core:$version"
}
