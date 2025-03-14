plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.navigation.safe.args)
    alias(libs.plugins.spotless)
    alias(libs.plugins.kotlin.serialize)
    alias(libs.plugins.kotlin.parcelize)


}

android {
    namespace = "com.example.cowrywisetest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cowrywisetest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose.android)
    implementation(libs.androidx.room.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))


    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)

    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    //hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.android.testing)
    ksp(libs.hilt.compiler)
    
    // viewModel
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.hilt.navigation.compose)


    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converterGson)
    implementation(libs.okhttp)
    implementation(libs.loggingInterceptor)

    implementation(libs.accompanist.systemuicontroller)

    implementation(libs.kotlinx.metadata.jvm)
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)








}

spotless {
    java {
        target("src/**/*.java")
        googleJavaFormat()
    }
    kotlin {
        target("src/**/*.kt")
        ktlint("0.48.1").userData(mapOf("android" to "true"))
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
    }
}