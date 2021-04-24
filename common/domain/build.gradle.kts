plugins {
    id("base-kotlin-library")
}

dependencies {
    implementation(project(Modules.dataModel))
    implementation(project(Modules.dataRepository))
    implementation(Dependencies.koin)
}