import net.minecraftforge.gradle.userdev.UserDevExtension

buildscript {
    repositories {
        maven { url = uri("https://repo.siro256.dev/repository/maven-public/") }
    }

    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:5.1.+") {
            isChanging = true
        }
    }
}

apply(plugin = "net.minecraftforge.gradle")

group = "${rootProject.group}.module.b"

dependencies {
    api(project(":moduleA").dependencyProject.buildDir.let { fileTree(File(it, "devlibs")) })
    api(kotlin("stdlib"))

    add("minecraft", "net.minecraftforge:forge:1.18.2-40.0.12")
}

configure<UserDevExtension> {
    mappings("official", "1.18.2")
}

tasks.compileKotlin.get().dependsOn(":moduleA:jar")
