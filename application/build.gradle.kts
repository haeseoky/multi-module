dependencies{
    implementation(project(":domain"))
    implementation("org.springframework:spring-tx:5.3.23")

}
val jar: Jar by tasks
jar.enabled = true

val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks
bootJar.enabled = false