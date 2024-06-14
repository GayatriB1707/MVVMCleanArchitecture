package com.example.feature

import com.example.feature.domain.entity.UsersEntity
import com.example.feature.domain.repo.UsersRepository
import com.example.feature.domain.use_cases.UsersUseCases
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class UsersUseCasesTest {
    private lateinit var getUsersRepository: UsersRepository
    private lateinit var getUsersUseCases: UsersUseCases
    private val usersList = mock<List<UsersEntity>>()

    @BeforeEach
    fun setUp() {
        getUsersRepository = mock()
        getUsersUseCases = UsersUseCases(getUsersRepository)

    }

    @Test
    fun returnUserSuccess() = runTest {
        `when`(getUsersRepository.getAllUsers()).thenReturn(
            usersList
        )
        getUsersUseCases.invoke().onEach {
            Assert.assertEquals(usersList, it.data)
        }
    }

    @Test
    fun returnUserError() = runTest {
        `when`(getUsersRepository.getAllUsers()).thenThrow(
            RuntimeException("Something Went Wrong")
        )
        getUsersUseCases.invoke().onEach {
            Assert.assertEquals("Something Went Wrong", it.message)
        }
    }
}
