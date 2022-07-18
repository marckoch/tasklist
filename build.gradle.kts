import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "me.marckoch"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

// special treatment because we receive input from StdIn
val run by tasks.getting(JavaExec::class) {
    standardInput = System.`in`
}

application {
    mainClassName = (properties["mainClass"] ?: "stage1.MainKt") as String
}