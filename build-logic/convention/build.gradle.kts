import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

val javaVersion: JavaVersion = JavaVersion.VERSION_17

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = javaVersion.toString()
    }
}

dependencies {
    compileOnly(libs.plugin.androidGradlePlugin)
    compileOnly(libs.plugin.kotlinGradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "anemonestudio.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "anemonestudio.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
    }
}
