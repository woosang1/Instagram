plugins {
    id("instagram.android.library")
}

android {
    namespace = "com.example.feature"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}