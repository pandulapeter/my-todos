object Dependencies {

    // General
    const val compose = "https://maven.pkg.jetbrains.space/public/p/compose/dev"
    const val composePlugin = "org.jetbrains.compose:compose-gradle-plugin:${Versions.compose}"
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val koin = "io.insert-koin:koin-core:${Versions.koin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    // Android
    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.androidAppCompat}"
    const val androidCompose = "androidx.activity:activity-compose:${Versions.androidCompose}"
    const val androidKoin = "io.insert-koin:koin-androidx-compose:${Versions.koin}"

    // Desktop
    const val desktopKoin = "io.insert-koin:koin-core-ext:${Versions.koin}"
}