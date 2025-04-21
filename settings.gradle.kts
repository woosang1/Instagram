pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Instagram"

include(":app")
include(":core:base")
include(":core:database")
include(":core:designsystem")
include(":core:model")
include(":core:navigation")
include(":core:network")
include(":core:resource")
include(":core:ui")
include(":core:utils")
include(":core:testing")
include(":app")
include(":feature")
include(":domain")
include(":data")
include(":enviroment")
include(":feature:main")
include(":feature:home")
include(":feature:shorts")
include(":feature:upload")
include(":feature:subscribe")
include(":feature:myPage")
