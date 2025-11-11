package com.example.instagram.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

        val androidExtension = extensions.findByName("android") as? CommonExtension<*, *, *, *, *, *>
            ?: error("Android extension not found while applying compose convention")

        androidExtension.buildFeatures.compose = true
    }
}

