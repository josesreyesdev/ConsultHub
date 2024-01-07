plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.jsrdev.consulthub"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jsrdev.consulthub"
        minSdk = 25
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }

    // acceder archivos del directorio de recursos
    sourceSets {
        getByName("test") {
            resources.srcDirs("src/test/res")
        }
        getByName("androidTest") {
            resources.srcDirs("src/androidTest/res")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Lifecycle libraries
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.okhttp)

    // Moshi
    implementation(libs.moshi.kotlin)
    // Retrofit with Moshi Converter
    implementation(libs.converter.moshi)

    // Coil
    implementation(libs.coil)

    // room
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)

    // unit test
    testImplementation(libs.junit)
    testImplementation(libs.androidx.core.testing)
    /* permite crear un servidor simulado intercepta las solicitudes de red y las redirige para mostrar estos*/
    testImplementation(libs.mockwebserver)
    
    // integration test
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}