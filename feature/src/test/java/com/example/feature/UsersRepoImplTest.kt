package com.example.feature

import com.example.core.ui.common.Resource
import com.example.feature.domain.entity.UsersEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import com.example.feature.domain.repo.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@OptIn(ExperimentalCoroutinesApi::class)
class UsersRepoImplTest : UsersRepository {
    val usersApiResponse1 = UsersEntity(
        userID = 1, userName = "abc", userUserName = "test", userEmail = "abc@gmail.com"
    )
    val usersApiResponse2 = UsersEntity(
        userID = 1, userName = "xyz", userUserName = "test", userEmail = "abc@gmail.com"
    )
    val users: List<UsersEntity> = listOf(usersApiResponse1, usersApiResponse2)
    override suspend fun getAllUsers(): Flow<Resource<List<UsersEntity>>> {
        return flow {
            emit(Resource.Success(users))
        }.flowOn(Dispatchers.IO)
    }
}
