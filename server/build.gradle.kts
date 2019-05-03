allprojects {
    group = "com.graphql.play.server"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
        jcenter()
    }
}

buildscript {
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.1.4.RELEASE")
    }
}

val springBootVersion = "2.1.4.RELEASE"
val h2Version = "1.4.198"
val graphQlSpringBootStarterVersion = "5.0.2"
val graphQlJavaDevToolVersion = "5.2.4"
val graphQlKotlinVersion = "0.2.13"

plugins {
    id("org.jetbrains.kotlin.plugin.jpa") version "1.2.71"
    id("org.springframework.boot") version "2.1.3.RELEASE"
    id("org.jetbrains.kotlin.jvm") version "1.2.71"
    id("org.jetbrains.kotlin.plugin.spring") version "1.2.71"
}

apply(plugin = "io.spring.dependency-management")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")
    implementation("com.graphql-java:graphql-spring-boot-starter:$graphQlSpringBootStarterVersion")
//    implementation("com.graphql-java:graphiql-spring-boot-starter:$graphQlSpringBootStarterVersion")
    implementation("com.graphql-java:graphql-java-tools:$graphQlJavaDevToolVersion")
    implementation("com.graphql-java:graphql-java:12.0")
    implementation("com.graphql-java:graphql-java-servlet:6.1.3")
//    compile("com.expedia:graphql-kotlin:$graphQlKotlinVersion")
    runtime("com.h2database:h2:$h2Version")
    compile("org.jetbrains.kotlin:kotlin-reflect")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

tasks.getByName<Jar>("jar") {
    enabled = true
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }
