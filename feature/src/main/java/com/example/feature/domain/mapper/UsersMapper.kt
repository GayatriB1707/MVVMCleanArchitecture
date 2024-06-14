package com.example.feature.domain.mapper

import com.example.feature.data.remote.response.UsersApiResponse
import com.example.feature.domain.entity.UsersEntity


fun UsersApiResponse.toUserssEntities(): List<UsersEntity> {
    return this.map { currentObject ->
        UsersEntity(
            userID = currentObject.id,
            userName = currentObject.name.toString(),
            userUserName = currentObject.name.toString(),
            userEmail = currentObject.email.toString())
    }}
