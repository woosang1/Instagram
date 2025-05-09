plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.kotlin.android.ksp) apply false
    alias(libs.plugins.kotlin.serialization) apply false
}

apply {
    from("gradle/dependencyGraph.gradle")
}