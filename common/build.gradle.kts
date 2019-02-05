plugins {
    `java-library`
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.kapt")
    id("org.jetbrains.dokka")
}

val kotlinLoggingVersion: String by rootProject.extra
val junitJupiterVersion: String by rootProject.extra
val mockkVersion: String by rootProject.extra

val implementation: Configuration = configurations[JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME]
val testImplementation: Configuration = configurations[JavaPlugin.TEST_IMPLEMENTATION_CONFIGURATION_NAME]
val testRuntimeClasspath: Configuration = configurations[JavaPlugin.TEST_RUNTIME_CLASSPATH_CONFIGURATION_NAME]

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")

    testRuntimeClasspath("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}
