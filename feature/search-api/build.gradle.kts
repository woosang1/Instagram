plugins {
    id("instagram.android.library")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.search.api"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.serialization.json)
}

