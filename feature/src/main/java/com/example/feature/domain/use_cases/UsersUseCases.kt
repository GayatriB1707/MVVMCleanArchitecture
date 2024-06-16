package com.example.feature.domain.use_cases


import com.example.core.ui.common.Resource
import com.example.feature.domain.entity.UsersEntity
import com.example.feature.domain.repo.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class UsersUseCases @Inject constructor(private val usersRepo: UsersRepository) {
    operator suspend fun invoke(): Flow<Resource<List<UsersEntity>>> {
        return usersRepo.getAllUsers()
    }
}
