import org.gradle.api.JavaVersion

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.android.ksp)
}

android {
    namespace = "com.example.appconfig"
    compileSdk = 35

    defaultConfig {
        minSdk = 26
        buildConfigField("String", "INSTAGRAM_GRAPH_BASE_URL", "\"https://graph.instagram.com/\"")
        buildConfigField("String", "INSTAGRAM_MEDIA_BASE_URL", "\"https://www.instagram.com/\"")
        buildConfigField("String", "CLIENT_PLATFORM", "\"android\"")
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
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

    flavorDimensions += "IS_TEST_SERVER"
    productFlavors {
        create("alpha") {
            dimension = "IS_TEST_SERVER"
            buildConfigField("boolean", "IS_STAGING", "true")
        }
        create("prod") {
            dimension = "IS_TEST_SERVER"
            buildConfigField("boolean", "IS_STAGING", "false")
        }
    }
}
dependencies {
    implementation(project(":app-config:app-config-api"))

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    ksp(libs.androidx.hilt.compier)
}

