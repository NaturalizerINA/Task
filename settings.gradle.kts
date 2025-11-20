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
        buildscript {
            configurations.all {
                resolutionStrategy.dependencySubstitution {
                    substitute(module("com.intellij:annotations")).using(module("org.jetbrains:annotations:23.0.0"))
                }
            }
        }
    }
    plugins {
        // Add the KSP plugin definition here
        id("com.google.devtools.ksp") version "2.3.2" apply false
//        alias(libs.plugins.hilt) apply false
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
 