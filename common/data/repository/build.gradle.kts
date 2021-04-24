plugins {
    id("base-kotlin-library")
}

dependencies {
    implementation(Dependencies.koin)
    implementation(project(Modules.dataModel))
    implementation(project(Modules.dataSourceLocal))
    implementation(project(Modules.dataSourceRemote))
}