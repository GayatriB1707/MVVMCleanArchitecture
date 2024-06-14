package com.example.feature.di

import com.example.feature.data.remote.repository.UsersRepositoryImpl
import com.example.feature.domain.repo.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindUsersRepo(impl: UsersRepositoryImpl): UsersRepository
}