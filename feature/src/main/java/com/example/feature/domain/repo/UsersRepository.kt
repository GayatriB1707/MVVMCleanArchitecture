package com.example.feature.domain.repo

import com.example.core.ui.common.Resource
import com.example.feature.domain.entity.UsersEntity
import kotlinx.coroutines.flow.Flow

interface  UsersRepository {
    suspend fun getAllUsers(): Flow<Resource<List<UsersEntity>>>
}