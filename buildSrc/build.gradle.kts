plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("base-kotlin-library-plugin") {
            id = "base-kotlin-library"
            implementationClass = "plugins.BaseKotlinLibrary"
        }
        register("base-android-library-plugin") {
            id = "base-android-library"
            implementationClass = "plugins.BaseAndroidLibrary"
        }
        register("base-kotlin-multiplatform-library-plugin") {
            id = "base-kotlin-multiplatform-library"
            implementationClass = "plugins.BaseMultiplatformLibrary"
        }
    }
}

repositories {
    mavenCentral()
}