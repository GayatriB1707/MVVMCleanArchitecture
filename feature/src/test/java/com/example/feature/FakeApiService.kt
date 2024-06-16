package com.example.feature

import com.example.feature.data.remote.response.UsersApiResponse
import com.example.feature.data.remote.service.UsersApiService

class FakeApiService : UsersApiService {
    override suspend fun getAllUsers(): UsersApiResponse {
        return UsersApiResponse().apply {
            addAll(
                listOf(
                    UsersApiResponse.UsersApiResponseItem(
                        email = "abc@gmail.com",
                        id = 1,
                        name = "abc",
                        username = "test"
                    ),
                    UsersApiResponse.UsersApiResponseItem(
                        email = "abc@gmail.com",
                        id = 1,
                        name = "abc",
                        username = "test"
                    ),
                    UsersApiResponse.UsersApiResponseItem(
                        email = "abc@gmail.com",
                        id = 1,
                        name = "abc",
                        username = "test"
                    ),
                    UsersApiResponse.UsersApiResponseItem(
                        email = "abc@gmail.com",
                        id = 1,
                        name = "abc",
                        username = "test"
                    ),
                    UsersApiResponse.UsersApiResponseItem(
                        email = "abc@gmail.com",
                        id = 1,
                        name = "abc",
                        username = "test"
                    )
                )
            )
        }
    }
}