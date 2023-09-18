import com.android.build.api.dsl.ApplicationExtension
import com.jguruproject.anemonestudio.Config
import com.jguruproject.anemonestudio.extensions.android
import com.jguruproject.anemonestudio.extensions.id
import com.jguruproject.anemonestudio.extensions.kotlinOptions
import com.jguruproject.anemonestudio.extensions.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) = target.run {
        plugins {
            id("com.android.application")
            id("org.jetbrains.kotlin.android")
        }

        android<ApplicationExtension> {
            compileSdk = Config.Android.compileSdk
            buildToolsVersion = Config.Android.buildTools
            defaultConfig {
                minSdk = Config.Android.minSdk
                targetSdk = Config.Android.targetSdk
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
