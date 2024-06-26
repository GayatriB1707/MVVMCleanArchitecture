package com.example.feature

import assertk.assertThat
import assertk.assertions.isTrue
import com.example.feature.domain.use_cases.UsersUseCases
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UsersUseCasesTest {
    private lateinit var getUsersUseCases: UsersUseCases
    private lateinit var fakeUsersRepoImplTest: UsersRepoImplTest

    @BeforeEach
    fun setUp() {
        fakeUsersRepoImplTest = UsersRepoImplTest()
        getUsersUseCases = UsersUseCases(fakeUsersRepoImplTest)
    }

    @Test
    fun `get users list`() = runTest {
        val users = getUsersUseCases().first()
        assertThat((users.data?.get(0)?.userName.equals("abc"))).isTrue()
    }
}
