package com.example.appconfig

import com.example.appconfig.api.InstagramBuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class InstagramBuildConfigImpl @Inject constructor() : InstagramBuildConfig {
    override val isStaging: Boolean get() = BuildConfig.IS_STAGING
    override val graphBaseUrl: String get() = BuildConfig.INSTAGRAM_GRAPH_BASE_URL
    override val mediaBaseUrl: String get() = BuildConfig.INSTAGRAM_MEDIA_BASE_URL
    override val clientPlatform: String get() = BuildConfig.CLIENT_PLATFORM
}

