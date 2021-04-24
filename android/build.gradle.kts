plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    compileSdkVersion(Config.androidTargetSdkVersion)
    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(Config.androidMinSdkVersion)
        targetSdkVersion(Config.androidTargetSdkVersion)
        versionCode = Config.androidVersionCode
        versionName = Config.versionName
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(Modules.presentation))
    implementation(Dependencies.androidCompose)
    implementation(Dependencies.androidAppCompat)
    implementation(Dependencies.androidKoin)
    implementation(project(Modules.dataSourceLocalImpl))
    implementation(project(Modules.dataSourceRemoteImpl))
    implementation(project(Modules.dataRepository))
    implementation(project(Modules.domain))
}