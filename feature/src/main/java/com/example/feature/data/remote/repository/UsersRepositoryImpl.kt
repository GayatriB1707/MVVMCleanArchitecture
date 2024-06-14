package com.example.feature.data.remote.repository

import com.example.feature.data.remote.service.UsersApiService
import com.example.feature.domain.entity.UsersEntity
import com.example.feature.domain.mapper.toUserssEntities
import com.example.feature.domain.repo.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val usersApiService: UsersApiService) :
    UsersRepository {
    override suspend fun getAllUsers(): List<UsersEntity> {
        return  usersApiService.getAllUsers().toUserssEntities()
    }
}
