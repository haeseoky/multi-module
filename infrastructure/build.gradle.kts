apply(plugin = "org.jetbrains.kotlin.plugin.jpa")

val springCloudVersion: String by project
val springFoxVersion: String by project

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
    }
}

dependencies{
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // feign
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation(project(":domain"))
    runtimeOnly("mysql:mysql-connector-java")
    implementation("com.h2database:h2")
}
val jar: Jar by tasks
jar.enabled = true

val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks
bootJar.enabled = false