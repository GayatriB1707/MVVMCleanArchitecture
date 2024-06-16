package com.example.feature.data.remote.repository

import com.example.core.ui.common.Resource
import com.example.feature.data.remote.service.UsersApiService
import com.example.feature.domain.entity.UsersEntity
import com.example.feature.domain.mapper.toUserssEntities
import com.example.feature.domain.repo.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val usersApiService: UsersApiService) :
    UsersRepository {
    override suspend fun getAllUsers(): Flow<Resource<List<UsersEntity>>> {
        return flow {
            try {
                emit(Resource.Success(usersApiService.getAllUsers().toUserssEntities()))
            } catch (e: Exception) {
                emit(Resource.Error(message = e.message))
            }
        }.flowOn(Dispatchers.IO)
    }
}
