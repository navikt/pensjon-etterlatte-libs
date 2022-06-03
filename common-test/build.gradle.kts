
dependencies {
    api(kotlin("stdlib"))
    api(kotlin("reflect"))

    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.12.1")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.12.1")
    api("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")

    implementation(project(":common"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    testImplementation("io.kotest:kotest-assertions-core:4.6.3")
}
