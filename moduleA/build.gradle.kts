plugins {
    id("fabric-loom") version "0.11-SNAPSHOT"
}

group = "${rootProject.group}.module.a"

dependencies {
    implementation(kotlin("stdlib"))

    add("minecraft", "com.mojang:minecraft:1.18.2")
    add("mappings", loom.officialMojangMappings())
}
