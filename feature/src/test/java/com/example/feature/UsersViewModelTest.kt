package com.example.feature

import app.cash.turbine.test
import assertk.assertThat
import com.example.feature.domain.entity.UsersEntity
import com.example.feature.presentation.UsersViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import assertk.assertions.isEqualTo
import com.example.core.ui.common.Resource
import com.example.feature.domain.use_cases.UsersUseCases
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class UsersViewModelTest {
    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    var usersUseCases: UsersUseCases = mock()

    @InjectMocks
    lateinit var userViewModel: UsersViewModel

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
        userViewModel = UsersViewModel(usersUseCases)
    }

    @Test
    fun `test loading users success`() = testScope.runTest {
        val mockUsers = listOf(UsersEntity(1, "1", "", ""))
        `when`(usersUseCases.invoke()).thenReturn(flowOf(Resource.Success(mockUsers)))
        userViewModel.allUsers.test {
            userViewModel.allUsers
            assertThat(awaitItem().data?.size).isEqualTo(1)
            awaitComplete()
        }
    }

    @Test
    fun `test loading users failure`() = testScope.runTest {
        val errorMessage = "Error Message"
        `when`(usersUseCases.invoke()).thenReturn(flowOf(Resource.Error(message = errorMessage)))
        userViewModel.allUsers.test {
            userViewModel.allUsers
            assertThat(awaitItem().error).isEqualTo(errorMessage)
            awaitComplete()
        }
    }
}
