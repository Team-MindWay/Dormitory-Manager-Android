package com.kim.Dormitorymanager.module

import com.kim.Dormitorymanager.datasource.GAuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import remote.datasource.GAuthDataSource
import remote.datasource.users.UsersDataSource
import remote.datasource.users.UsersDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun provideAuthDatasource(
        gAuthDataSourceImpl: GAuthDataSourceImpl
    ): GAuthDataSource
    @Binds
    abstract fun provideUsersDatasource(
        usersDataSourceImpl: UsersDataSourceImpl
    ): UsersDataSource
}
