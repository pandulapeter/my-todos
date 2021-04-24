package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class BaseKotlinLibrary : Plugin<Project> {

    override fun apply(target: Project) = target.kotlinLibrary()
}