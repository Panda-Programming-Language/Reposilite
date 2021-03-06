import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
    kotlin("plugin.serialization") version "1.4.31"
    application
}

group = "org.panda_lang"
version = "1.0.0"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
    maven { url = uri("https://dl.bintray.com/kotlin/ktor") }
}

dependencies {
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
    implementation("com.michael-bull.kotlin-result:kotlin-result:1.1.11")

    val kmongo = "4.2.4"
    implementation("org.litote.kmongo:kmongo:$kmongo")
    implementation("org.litote.kmongo:kmongo-coroutine:$kmongo")
    implementation("org.litote.kmongo:kmongo-async:$kmongo")
    implementation("org.litote.kmongo:kmongo-reactor:$kmongo")

    val ktor = "1.5.2"
    implementation("io.ktor:ktor-auth-jwt:$ktor")
    implementation("io.ktor:ktor-auth:$ktor")
    implementation("io.ktor:ktor-locations:$ktor")
    implementation("io.ktor:ktor-client-apache:$ktor")
    implementation("io.ktor:ktor-server-netty:$ktor")
    implementation("io.ktor:ktor-html-builder:$ktor")
    implementation("io.ktor:ktor-client-gson:$ktor")
    implementation("io.ktor:ktor-gson:$ktor")
    implementation("io.ktor:ktor-serialization:$ktor")
    implementation("io.ktor:ktor-client-serialization:$ktor")
    testImplementation("io.ktor:ktor-server-test-host:$ktor")
    testImplementation("io.ktor:ktor-client-mock:$ktor")

    val tinylog = "2.2.1"
    implementation("org.tinylog:tinylog-api-kotlin:$tinylog")
    implementation("org.tinylog:tinylog-impl:$tinylog")
    implementation("org.tinylog:slf4j-tinylog:$tinylog")

    val junit = "5.7.1"
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit")
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junit")

    val testcontainers = "1.15.2"
    testImplementation("org.testcontainers:testcontainers:$testcontainers")
    testImplementation("org.testcontainers:junit-jupiter:$testcontainers")
    testImplementation("org.testcontainers:mongodb:$testcontainers")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=io.ktor.util.KtorExperimentalAPI"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=io.ktor.locations.KtorExperimentalLocationsAPI"
}

application {
    mainClassName = "org.panda_lang.hub.HubApplicationKt"
}