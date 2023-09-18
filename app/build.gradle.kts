plugins {
    id("anemonestudio.android.application")
}

android {
    namespace = "com.jguruproject.anemonestudio"
    defaultConfig {
        applicationId = "com.jguruproject.anemonestudio"
        versionCode = 1
        versionName = "0.1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            applicationIdSuffix = ".debug"
        }
    }
    buildFeatures {
//        compose = true
    }
    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    implementation(project(":library:theme"))
    implementation(platform(libs.androidx.composeBom))
}
