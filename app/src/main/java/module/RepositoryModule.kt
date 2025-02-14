package com.kim.Dormitorymanager.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import reopoistory.HomesRepository
import reopoistory.UsersRepository
import repository.AuthRepository
import repoistory.AuthRepositoryImpl
import repoistory.HomeRepositoryImpl
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
    @Binds
    abstract fun providerHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomesRepository


}