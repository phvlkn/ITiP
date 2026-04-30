import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

plugins {
    java
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // junit (как в листинге 2.1 методички)
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