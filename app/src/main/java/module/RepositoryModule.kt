package com.kim.Dormitorymanager.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import reopoistory.UsersRepository
import repository.AuthRepository
import repoistory.AuthRepositoryImpl
import repoistory.UsersRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providerAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ):AuthRepository
    @Binds
    abstract fun providerUsersRepository(
        usersRepositoryImpl: UsersRepositoryImpl
    ): UsersRepository

}