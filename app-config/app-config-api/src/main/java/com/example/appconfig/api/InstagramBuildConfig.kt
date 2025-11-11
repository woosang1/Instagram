package com.example.appconfig.api

/**
 * Abstraction that exposes build-time configuration flags and service entry points.
 * Implemented inside the `app-config` module so feature modules can remain platform agnostic.
 */
interface InstagramBuildConfig {
    val isStaging: Boolean
    val graphBaseUrl: String
    val mediaBaseUrl: String
    val clientPlatform: String
}

