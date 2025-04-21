plugins {
    id("java")
}

group = "com.wasm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.dylibso.chicory:runtime:1.2.1")
    implementation("com.dylibso.chicory:wasm:1.2.1")
    implementation("com.dylibso.chicory:wasi:1.2.1")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}