package com.example.appconfig.di

import com.example.appconfig.InstagramBuildConfigImpl
import com.example.appconfig.api.InstagramBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object InstagramBuildConfigModule {

    @Provides
    @Singleton
    fun provideInstagramBuildConfig(): InstagramBuildConfig = InstagramBuildConfigImpl()
}

