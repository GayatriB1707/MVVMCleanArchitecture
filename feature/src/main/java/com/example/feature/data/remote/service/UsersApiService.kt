package com.example.feature.data.remote.service

import com.example.core.constants.AppConstants
import com.example.feature.data.remote.response.UsersApiResponse
import retrofit2.http.GET

interface UsersApiService {
    @GET(AppConstants.GET_USERS)
    suspend fun getAllUsers(): UsersApiResponse
}
