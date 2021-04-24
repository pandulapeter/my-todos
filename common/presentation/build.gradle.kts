import org.jetbrains.compose.compose

plugins {
    id("base-kotlin-library")
    id("org.jetbrains.compose")
}

dependencies {
    api(compose.runtime)
    api(compose.foundation)
    api(compose.material)
    implementation(project(Modules.dataModel))
    implementation(project(Modules.domain))
    implementation(Dependencies.koin)
}
