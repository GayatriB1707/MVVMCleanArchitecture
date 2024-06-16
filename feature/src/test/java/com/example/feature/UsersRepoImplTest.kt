package com.example.feature


import com.example.core.ui.common.Resource
import com.example.feature.data.remote.service.UsersApiService
import com.example.feature.domain.entity.UsersEntity
import com.example.feature.domain.mapper.toUserssEntities
import kotlinx.coroutines.ExperimentalCoroutinesApi
import com.example.feature.domain.repo.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@OptIn(ExperimentalCoroutinesApi::class)
class UsersRepoImplTest(val fakeApi: UsersApiService) : UsersRepository {
    override suspend fun getAllUsers(): Flow<Resource<List<UsersEntity>>> {
        return flow {
            try {
                emit(Resource.Success(fakeApi.getAllUsers().toUserssEntities()))
            } catch (e: Exception) {
                emit(Resource.Error(message = e.message))
            }
        }.flowOn(Dispatchers.IO)
    }
}
