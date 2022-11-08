dependencies{
}
val jar: Jar by tasks
jar.enabled = true

val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks
bootJar.enabled = false