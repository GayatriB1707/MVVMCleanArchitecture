package com.example.feature.domain.use_cases


import com.example.core.ui.common.Resource
import com.example.feature.domain.entity.UsersEntity
import com.example.feature.domain.repo.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

open class UsersUseCases @Inject constructor(private val usersRepo: UsersRepository) {
    operator suspend fun invoke(): Flow<Resource<List<UsersEntity>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(usersRepo.getAllUsers()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message))
        }
    }

}
