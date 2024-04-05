plugins {
    id("java")
    id("org.springframework.boot") version "2.7.17"
    id("application")
}

apply(plugin = "io.spring.dependency-management")

group = "ru.kpfu.itis.paramonov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    annotationProcessor("org.hibernate:hibernate-jpamodelgen:${properties["hibernateVersion"]}")
    implementation("org.postgresql:postgresql:42.7.2")
    implementation("org.apache.tomcat:tomcat-jsp-api:10.1.20")
    implementation("javax.servlet.jsp:jsp-api:2.1")

    compileOnly("org.projectlombok:lombok:${properties["lombokVersion"]}")
    annotationProcessor("org.projectlombok:lombok:${properties["lombokVersion"]}")
    implementation("org.slf4j:slf4j-api:${properties["slf4jVersion"]}")
    implementation("org.slf4j:slf4j-simple:${properties["slf4jVersion"]}")
    implementation("com.google.code.gson:gson:${properties["gsonVersion"]}")
}

tasks.test {
    useJUnitPlatform()
}