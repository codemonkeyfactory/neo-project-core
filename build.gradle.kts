plugins {
    val kotlinVersion = "1.3.20" // use same kotlin version as current spring boot version
    val springBootVersion = "2.1.2.RELEASE"
    val springDmVersion = "1.0.6.RELEASE"
    val dokkaVersion = "0.9.17"
    val testSetsVersion = "2.1.1"

    kotlin("jvm") version kotlinVersion apply false
    kotlin("kapt") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    kotlin("plugin.jpa") version kotlinVersion apply false
    id("org.springframework.boot") version springBootVersion apply false
    id("io.spring.dependency-management") version springDmVersion apply false
    id("org.jetbrains.dokka") version dokkaVersion apply false
    id("org.unbroken-dome.test-sets") version testSetsVersion apply false
}

val gradleVersion by extra { "5.2-rc-1" }
val kotlinVersion by extra {
    buildscript.configurations["classpath"]
        .resolvedConfiguration.firstLevelModuleDependencies
        .find { it.moduleName == "org.jetbrains.kotlin.jvm.gradle.plugin" }?.moduleVersion
}
val kotlinLoggingVersion by extra { "1.6.22" }
val junitJupiterVersion by extra { "5.3.2" }
val mockkVersion by extra { "1.9" }
val cucumberVersion by extra { "4.2.2" }
val springBootVersion by extra {
    buildscript.configurations["classpath"]
        .resolvedConfiguration.firstLevelModuleDependencies
        .find { it.moduleName == "org.springframework.boot.gradle.plugin" }?.moduleVersion
}

tasks {
    val gradleVersionExtra = gradleVersion // gradleVersion is shadowed inside wrapper task

    withType<Wrapper> {
        gradleVersion = gradleVersionExtra
        distributionType = Wrapper.DistributionType.ALL
    }
}

allprojects {
    group = "com.codemonkeyfactory"
    version = "1.0-SNAPSHOT"
}