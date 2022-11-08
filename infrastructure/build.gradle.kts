dependencies{
    implementation(project(":domain"))
    runtimeOnly("mysql:mysql-connector-java")
    testRuntimeOnly("com.h2database:h2")
}
val jar: Jar by tasks
jar.enabled = true

val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks
bootJar.enabled = false