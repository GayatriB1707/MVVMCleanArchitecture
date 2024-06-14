package com.example.feature

import com.example.core.ui.common.Resource
import com.example.feature.domain.entity.UsersEntity
import com.example.feature.domain.use_cases.UsersUseCases
import com.example.feature.presentation.UsersViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@ExperimentalCoroutinesApi
class UsersViewModelTest {
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val usersUseCases: UsersUseCases = mock()
    private lateinit var usersViewModel: UsersViewModel
    private val usersList: List<UsersEntity>? = mock()

    @BeforeEach
    fun setup() {
        usersViewModel = UsersViewModel(usersUseCases)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun validateProgressBar() = runTest {
        `when`(usersUseCases.invoke()).thenReturn(
            flow {
                emit(Resource.Loading())
            }
        )
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(true, usersViewModel.usersState.value.isLoading)
    }

    @Test
    fun validateSuccessState() = runTest {
        `when`(usersUseCases.invoke()).thenReturn(
            flow {
                emit(Resource.Success(usersList))
            }
        )
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(usersList, usersViewModel.usersState.value.data)
    }

    @Test
    fun throwErrorInErrorCase() = runTest {
        `when`(usersUseCases.invoke()).thenReturn(
            flow {
                emit(Resource.Error("Something Went Wrong"))
            }
        )
        mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals("Something Went Wrong", usersViewModel.usersState.value.error)
    }
}
