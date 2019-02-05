rootProject.name = "neo-project-core"

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
        gradlePluginPortal()
    }
}

include("common")
include("email")
