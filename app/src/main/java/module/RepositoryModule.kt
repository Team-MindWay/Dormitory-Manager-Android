package com.kim.Dormitorymanager.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import reopoistory.AdminRepository
import reopoistory.HomesRepository
import reopoistory.NoticeRepository
import reopoistory.UsersRepository
import repoistory.AdminRepositoryImpl
import repository.AuthRepository
import repoistory.AuthRepositoryImpl
import repoistory.HomeRepositoryImpl
import repoistory.NoticeRepositoryImpl
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
    @Binds
    abstract fun providerNoticeRepository(
        noticeRepositoryImpl: NoticeRepositoryImpl
    ): NoticeRepository
    @Binds
    abstract fun providerAdminRepository(
        adminRepositoryImpl: AdminRepositoryImpl
    ): AdminRepository
}