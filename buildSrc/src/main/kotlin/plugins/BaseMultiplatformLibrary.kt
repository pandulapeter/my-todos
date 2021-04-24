package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class BaseMultiplatformLibrary : Plugin<Project> {

    override fun apply(target: Project) = target.multiplatformLibrary()
}