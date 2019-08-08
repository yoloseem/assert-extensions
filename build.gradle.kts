import com.adarshr.gradle.testlogger.theme.ThemeType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.3.31"

buildscript {
    val kotlinVersion = "1.3.31"
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

plugins {
    java
    maven
    jacoco
    idea

    id("com.adarshr.test-logger") version "1.6.0"
}

apply {
    plugin("kotlin")
}

configure<JavaPluginConvention> {
    group = "im.toss"
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("com.google.guava:guava:27.1-jre")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.9.0")
    implementation("com.fasterxml.jackson.core:jackson-core:2.9.9")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.9")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.9")
    implementation("org.assertj:assertj-core:3.12.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.3.1")
    testImplementation("io.mockk:mockk:1.8.13")
}

repositories {
    mavenCentral()
}

val compileKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks

compileTestKotlin.kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
}

jacoco {
    toolVersion = "0.8.4"
}

tasks {
    test {
        useJUnitPlatform {
        }
    }

    jacocoTestReport {
        executionData.setFrom(
            fileTree("build/jacoco") {
                include("**/*.exec")
            }
        )

        reports {
            xml.isEnabled = true
            html.isEnabled = true
        }
    }

    jacocoTestCoverageVerification {
        dependsOn(setOf(jacocoTestReport))
        violationRules {
            rule {
                limit {
                    counter = "INSTRUCTION"
                    minimum = "1.000000000".toBigDecimal()
                }

                limit {
                    counter = "BRANCH"
                    minimum = "1.000000000".toBigDecimal()
                }
            }
        }
    }
}

testlogger {
    theme = ThemeType.STANDARD_PARALLEL
    showExceptions = true
    slowThreshold = 2000
    showSummary = true
    showPassed = true
    showSkipped = true
    showFailed = true
    showStandardStreams = false
    showPassedStandardStreams = false
    showSkippedStandardStreams = false
    showFailedStandardStreams = false
}

tasks.register<Jar>("sourcesJar") {
    from(sourceSets.main.get().allJava)
    archiveClassifier.set("sources")
}

tasks.register<Jar>("javadocJar") {
    from(tasks.javadoc)
    archiveClassifier.set("javadoc")
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}
