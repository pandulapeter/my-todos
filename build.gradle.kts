buildscript {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven(Dependencies.compose)
    }
    dependencies {
        classpath(Dependencies.composePlugin)
        classpath(Dependencies.gradle)
        classpath(Dependencies.kotlin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(Dependencies.compose)
    }
}