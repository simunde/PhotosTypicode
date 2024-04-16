plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")

}

android {
    namespace = "com.msid.photostypicode"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.msid.photostypicode"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildFeatures{
        dataBinding=true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    val roomVersion = "2.6.1"
    val lifecycleVersion = "2.7.0"

    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    // To use Kotlin Symbol Processing (KSP)
    ksp("androidx.room:room-compiler:$roomVersion")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //retrofit dependencies
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    // GSON
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")

    //mvvm
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")



    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}