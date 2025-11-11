plugins {
    `kotlin-dsl`
}

group = "com.example.instagram.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("instagramAndroidApplication") {
            id = "instagram.android.application"
            implementationClass = "com.example.instagram.buildlogic.AndroidApplicationConventionPlugin"
        }
        register("instagramAndroidLibrary") {
            id = "instagram.android.library"
            implementationClass = "com.example.instagram.buildlogic.AndroidLibraryConventionPlugin"
        }
        register("instagramAndroidCompose") {
            id = "instagram.android.compose"
            implementationClass = "com.example.instagram.buildlogic.AndroidComposeConventionPlugin"
        }
    }
}

