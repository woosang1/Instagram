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
include(":feature:home-api")
include(":feature:shorts")
include(":feature:shorts-api")
include(":feature:upload")
include(":feature:upload-api")
include(":feature:myPage")
include(":feature:myPage-api")
include(":feature:search")
include(":feature:search-api")
include(":feature:videoDetail")
include(":app-config:app-config")
include(":app-config:app-config-api")
include(":feature:videoDetail-api")
