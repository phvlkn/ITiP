import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.14.0")

    implementation("org.slf4j:slf4j-api:2.0.13")
    runtimeOnly("ch.qos.logback:logback-classic:1.5.6")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    // как в методичке: mainClass = "org.example.Main"
    mainClass = "org.example.Main"
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    manifest {
        attributes(mapOf("Main-Class" to "org.example.Main"))
    }
}

abstract class PrintInfoTask : DefaultTask() {
    @TaskAction
    fun print() {
        println("======================================")
        println("Это моя первая пользовательская задача!")
        println("Проект: ${project.name}")
        println("Версия Gradle: ${project.gradle.gradleVersion}")
        println("======================================")
    }
}

tasks.register<PrintInfoTask>("printInfo") {
    group = "Custom"
    description = "Выводит информацию о проекте"
}

abstract class GenerateBuildInfoTask : DefaultTask() {

    @TaskAction
    fun generate() {
        val resourcesDir = project.layout.projectDirectory.dir("src/main/resources").asFile
        if (!resourcesDir.exists()) resourcesDir.mkdirs()

        val outFile = resourcesDir.resolve("build-passport.properties")

        val user = System.getenv("USERNAME")
            ?: System.getenv("USER")
            ?: System.getProperty("user.name")
            ?: "unknown"

        val osName = System.getProperty("os.name") ?: "unknown"
        val javaVersion = System.getProperty("java.version") ?: "unknown"

        val dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        val content = buildString {
            appendLine("build.user=$user")
            appendLine("build.os=$osName")
            appendLine("build.java=$javaVersion")
            appendLine("build.datetime=$dt")
            appendLine("build.greeting=Hello from Gradle build!")
        }

        outFile.writeText(content, Charsets.UTF_8)

        println("Generated: ${outFile.absolutePath}")
    }
}

tasks.register<GenerateBuildInfoTask>("generateBuildInfo") {
    group = "Custom"
    description = "Генерирует build-passport.properties в ресурсах проекта"
}

tasks.named("processResources") {
    dependsOn(tasks.named("generateBuildInfo"))
}