plugins {
    id("instagram.android.library")
    alias(libs.plugins.kotlin.android.ksp)
}

android {
    namespace = "com.example.testing"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // test
    api(libs.coroutines.test)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation(libs.androidx.hilt.work)
    androidTestImplementation(libs.androidx.hilt.junit)
    testImplementation(libs.hilt.android.testing)
    kspTest(libs.hilt.android.compiler)
    implementation(libs.androidx.junit.ktx)
}