package com.example.feature

import app.cash.turbine.test
import assertk.assertThat
import com.example.feature.domain.entity.UsersEntity
import com.example.feature.presentation.UsersViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import assertk.assertions.isEqualTo
import com.example.core.ui.common.Resource
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.mockito.Mockito.doReturn

@ExperimentalCoroutinesApi
class UsersViewModelTest {
    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Mock
    lateinit var usersUseCases: UsersUseCasesTest

    @InjectMocks
    lateinit var userViewModel: UsersViewModel

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test loading users success`() = testScope.runTest {
        val mockUsers = listOf(UsersEntity(1, "1", "", ""))
        `when`(usersUseCases.invoke()).thenReturn(flowOf(Resource.Success(mockUsers)))
        userViewModel.allUsers.test {
            assertThat(awaitItem().data?.size).isEqualTo(1)
            awaitComplete()
        }
    }

    @Test
    fun `test loading users failure`() = testScope.runTest {
        val errorMessage = "Error Message"
        doReturn(flow<List<UsersEntity>> {
            throw IllegalStateException(errorMessage)
        }).`when`(usersUseCases).invoke()
        userViewModel.allUsers.test {
            assertTrue(awaitError() is IllegalStateException)
            assertEquals(
                errorMessage,
                awaitError().message
            )
        }
    }
}

