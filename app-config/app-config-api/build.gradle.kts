import org.gradle.api.JavaVersion

plugins {
    id("instagram.android.library")
}

android {
    namespace = "com.example.appconfig.api"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}

