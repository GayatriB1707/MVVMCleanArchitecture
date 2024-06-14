package com.example.feature


import com.example.feature.data.remote.repository.UsersRepositoryImpl
import com.example.feature.data.remote.response.UsersApiResponse
import com.example.feature.data.remote.service.UsersApiService
import com.example.feature.domain.mapper.toUserssEntities
import kotlinx.coroutines.ExperimentalCoroutinesApi
import com.example.feature.domain.repo.UsersRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class UsersRepoImplTest {
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()
    private lateinit var usersRepository: UsersRepository
    private lateinit var apiService: UsersApiService
    private val usersList = mock<UsersApiResponse>()

    @BeforeEach
    fun setUp() {
        apiService = mock()
        usersRepository = UsersRepositoryImpl(apiService)
    }

    @Test
    fun returnSuccessWhenGetUsers() = runTest {
        `when`(apiService.getAllUsers()).thenReturn(
            usersList
        )
        val result = usersRepository.getAllUsers()
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(usersList, result)
    }
}
