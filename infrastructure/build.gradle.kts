apply(plugin = "org.jetbrains.kotlin.plugin.jpa")

dependencies{
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(project(":domain"))
    runtimeOnly("mysql:mysql-connector-java")
    implementation("com.h2database:h2")
}
val jar: Jar by tasks
jar.enabled = true

val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks
bootJar.enabled = false