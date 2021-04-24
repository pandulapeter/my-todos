package plugins

import org.gradle.api.Project

fun Project.androidLibrary() {
    plugins.run {
        apply("com.android.library")
    }
    // TODO: Reduce code duplication: the android{} block should be here
}

fun Project.kotlinLibrary() {
    plugins.run {
        apply("java-library")
        apply("kotlin")
    }
}

fun Project.multiplatformLibrary() {
    androidLibrary()
    plugins.run {
        apply("org.jetbrains.kotlin.multiplatform")
    }
    // TODO: Reduce code duplication: the kotlin{} block should be here
}