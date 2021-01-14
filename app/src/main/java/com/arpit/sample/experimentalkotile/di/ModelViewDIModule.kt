package com.arpit.sample.experimentalkotile.di

import com.arpit.sample.experimentalkotile.FakeRepo
import com.arpit.sample.experimentalkotile.FakeRepo2
import com.arpit.sample.experimentalkotile.IRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier
import javax.inject.Singleton


@InstallIn(ActivityRetainedComponent::class)
@Module
class ModelViewDIModule {

    @Repo1
    @Provides
    @ActivityRetainedScoped
    fun getRepo() : IRepo{
        return FakeRepo()
    }

    @Repo2
    @Provides
    @ActivityRetainedScoped
    fun getRepo2() : IRepo{
        return FakeRepo2()
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Repo1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Repo2