plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
    id("maven-publish")
}

android {
    namespace = "com.lifestyle.zigplugins"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            afterEvaluate{
                from(components["release"])
            }
    }
}
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    api("com.google.zxing:core:3.5.3")
    api("androidx.camera:camera-camera2:1.3.4")
    api("androidx.camera:camera-lifecycle:1.3.4")
    api("androidx.camera:camera-view:1.3.4")
    api("com.squareup.okhttp3:okhttp:5.0.0-alpha.14")
    api("com.squareup.retrofit2:retrofit:2.11.0")
    api("com.squareup.retrofit2:converter-gson:2.11.0")
    api("com.airbnb.android:lottie:6.4.1")
    api("com.google.android.gms:play-services-location:21.3.0")
    api("androidx.localbroadcastmanager:localbroadcastmanager:1.1.0")
    api("androidx.room:room-runtime:2.6.1")
    api("androidx.room:room-ktx:2.6.1")
    ksp ("androidx.room:room-compiler:2.6.1")
    api("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5")
    api("com.google.android.flexbox:flexbox:3.0.0")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
}