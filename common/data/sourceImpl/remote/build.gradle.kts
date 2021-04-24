plugins {
    id("base-kotlin-multiplatform-library")
}

kotlin {
    android()
    jvm("desktop")
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(Dependencies.koin)
                implementation(project(Modules.dataModel))
                implementation(project(Modules.dataSourceRemote))
            }
        }
    }
}

android {
    compileSdkVersion(Config.androidTargetSdkVersion)
    defaultConfig {
        minSdkVersion(Config.androidMinSdkVersion)
        targetSdkVersion(Config.androidTargetSdkVersion)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }
}