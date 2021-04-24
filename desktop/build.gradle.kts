import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {
        withJava()
    }
    sourceSets {
        named("jvmMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(project(Modules.presentation))
                implementation(Dependencies.desktopKoin)
                implementation(project(Modules.dataSourceLocalImpl))
                implementation(project(Modules.dataSourceRemoteImpl))
                implementation(project(Modules.dataRepository))
                implementation(project(Modules.domain))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.pandulapeter.myTodos.MyTodosKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = Config.applicationId
            packageVersion = Config.versionName
        }
    }
}