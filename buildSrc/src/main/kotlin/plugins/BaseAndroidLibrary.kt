package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class BaseAndroidLibrary : Plugin<Project> {

    override fun apply(target: Project) = target.androidLibrary()
}