package com.example.feature.presentation.StateHolder

import com.example.feature.domain.entity.UsersEntity

data class StateHolder(
    val isLoading: Boolean = false,
    val data: List<UsersEntity>? = null,
    val error: String = ""
)
