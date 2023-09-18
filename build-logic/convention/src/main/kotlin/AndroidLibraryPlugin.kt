import com.android.build.gradle.LibraryExtension
import com.jguruproject.anemonestudio.Config
import com.jguruproject.anemonestudio.extensions.android
import com.jguruproject.anemonestudio.extensions.id
import com.jguruproject.anemonestudio.extensions.kotlinOptions
import com.jguruproject.anemonestudio.extensions.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) = target.run {
        plugins {
            id("com.android.library")
            id("org.jetbrains.kotlin.android")
        }

        android<LibraryExtension> {
            compileSdk = Config.Android.compileSdk
            buildToolsVersion = Config.Android.buildTools
            defaultConfig {
                minSdk = Config.Android.minSdk
                consumerProguardFiles("consumer-rules.pro")
            }
            buildTypes {
                release {
                    isMinifyEnabled = true
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                }
            }
            compileOptions {
                sourceCompatibility = Config.Java.version
                targetCompatibility = Config.Java.version
            }
            kotlinOptions {
                jvmTarget = Config.Java.version.toString()
            }
        }
    }
}
