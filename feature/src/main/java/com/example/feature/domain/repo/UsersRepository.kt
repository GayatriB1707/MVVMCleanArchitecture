package com.example.feature.domain.repo

import com.example.feature.domain.entity.UsersEntity

interface  UsersRepository {
    suspend fun getAllUsers(): List<UsersEntity>
}