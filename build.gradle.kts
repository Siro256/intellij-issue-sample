import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
}

group = "dev.siro256.issue_sample"

allprojects {
    apply(plugin = "kotlin")

    version = "1.0-SNAPSHOT"

    repositories {
        maven { url = uri("https://repo.siro256.dev/repository/maven-public/") }
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions.apply {
                allWarningsAsErrors = true
                jvmTarget = "17"
            }

            sourceCompatibility = "17"
            targetCompatibility = "17"
        }

        withType<ProcessResources> {
            duplicatesStrategy = DuplicatesStrategy.INCLUDE

            from(rootProject.file("LICENSE").path)
            rename { "LICENSE_${rootProject.name}" }
        }
    }

    configurations.all {
        resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
    }
}
