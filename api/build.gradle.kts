val springCloudVersion: String by project
val springCloudAWSVersion: String by project
//val springFoxVersion: String by project
val springdocOpenapiUi: String by project
val mockitoKotlinVersion: String by project
val kotlinxCoroutinesCore: String by project


dependencyManagement {
    imports {
        mavenBom("io.awspring.cloud:spring-cloud-aws-dependencies:${springCloudAWSVersion}")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
    }
}

dependencies {
    implementation(project(":application"))
    implementation(project(":domain"))
    implementation(project(":infrastructure"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

//    implementation("io.springfox:springfox-boot-starter:${springFoxVersion}")
    implementation("org.springdoc:springdoc-openapi-kotlin:${springdocOpenapiUi}")


    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    //kotlin coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${kotlinxCoroutinesCore}")

    testImplementation("org.mockito.kotlin:mockito-kotlin:${mockitoKotlinVersion}")
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation(kotlin("test"))
}
