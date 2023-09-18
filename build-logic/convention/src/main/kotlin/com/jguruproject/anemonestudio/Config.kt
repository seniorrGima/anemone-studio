package com.jguruproject.anemonestudio

import org.gradle.api.JavaVersion

object Config {

    object Android {
        const val compileSdk: Int = 33
        const val buildTools: String = "33.0.1"
        const val minSdk: Int = 30
        const val targetSdk: Int = 33
    }

    object Java {
        val version: JavaVersion = JavaVersion.VERSION_11
    }
}
