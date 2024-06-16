package com.example.feature

import com.example.feature.domain.use_cases.UsersUseCases
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
open class UsersUseCasesTest(usersRepositoryImplTest: UsersRepoImplTest) :
    UsersUseCases(usersRepositoryImplTest) {

}
