package com.example.network.di

import com.example.appconfig.api.InstagramBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

private const val GRAPH_BASE_URL = "instagramGraphBaseUrl"
private const val MEDIA_BASE_URL = "instagramMediaBaseUrl"

@Module
@InstallIn(SingletonComponent::class)
object NetworkConfigModule {

    @Provides
    @Singleton
    @Named(GRAPH_BASE_URL)
    fun provideGraphBaseUrl(config: InstagramBuildConfig): String = config.graphBaseUrl

    @Provides
    @Singleton
    @Named(MEDIA_BASE_URL)
    fun provideMediaBaseUrl(config: InstagramBuildConfig): String = config.mediaBaseUrl
}

