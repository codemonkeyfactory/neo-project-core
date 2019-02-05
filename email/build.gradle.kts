import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.unbrokendome.gradle.plugins.testsets.dsl.testSets

plugins {
    kotlin("jvm")
    kotlin("kapt")
    id("org.jetbrains.dokka")
    id("org.jetbrains.kotlin.plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.unbroken-dome.test-sets")
}

val integrationTestName = "integrationTest"

testSets {
    integrationTestName {
        dirName = integrationTestName.toKebabCase()
    }
}

val kotlinLoggingVersion: String by rootProject.extra
val junitJupiterVersion: String by rootProject.extra
val mockkVersion: String by rootProject.extra
val cucumberVersion: String by rootProject.extra

val integrationTestImplementation: Configuration = configurations["${integrationTestName}Implementation"]

dependencyManagement {
    imports {
        mavenBom("org.junit:junit-bom:$junitJupiterVersion")
    }
}

dependencies {
    implementation(project(":common"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("io.github.microutils:kotlin-logging:$kotlinLoggingVersion")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")

    implementation("org.springframework.boot:spring-boot-starter-validation")
    kapt("org.hibernate.validator:hibernate-validator-annotation-processor")

    implementation("org.springframework.boot:spring-boot-starter-web")

    compileOnly("org.springframework.boot:spring-boot-configuration-processor")
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("io.mockk:mockk:$mockkVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    integrationTestImplementation("io.cucumber:cucumber-java8:$cucumberVersion")
    integrationTestImplementation("io.cucumber:cucumber-junit:$cucumberVersion")
    integrationTestImplementation("io.cucumber:cucumber-spring:$cucumberVersion")

    testRuntimeClasspath("org.junit.jupiter:junit-jupiter-engine")
}

configurations {
    all {
        // required to exclude this module because we are using log4j2
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
}

// kotlin options
val kotlinApiVersion by extra { "1.3" }
val kotlinLanguageVersion by extra { "1.3" }
val kotlinJvmTarget by extra { "1.8" }
val kotlinFreeCompilerArgs by extra { listOf("-version", "-Xjsr305=strict") }

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            apiVersion = kotlinApiVersion
            languageVersion = kotlinLanguageVersion
            jvmTarget = kotlinJvmTarget
            freeCompilerArgs = kotlinFreeCompilerArgs
        }
    }

    withType<Test> {
        useJUnitPlatform()
    }

    val integrationTest = getByName(integrationTestName) {
        mustRunAfter(getByName("test"))
    }

    getByName("check") {
        dependsOn(integrationTest)
    }
}
