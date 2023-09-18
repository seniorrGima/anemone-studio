@file:Suppress("NOTHING_TO_INLINE")

package com.jguruproject.anemonestudio.extensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

inline fun Project.plugins(noinline block: PluginManager.() -> Unit) {
    pluginManager.apply(block)
}

inline fun <reified T> Project.android(noinline block: T.() -> Unit) where T : CommonExtension<*, *, *, *, *> {
    extensions.configure(block)
}

inline fun Project.kotlinOptions(noinline block: KotlinJvmOptions.() -> Unit) {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions(block)
    }
}

inline fun PluginManager.id(id: String) {
    apply(id)
}
