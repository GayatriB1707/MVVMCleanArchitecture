package com.example.feature.presentation

import com.example.core.ui.common.Resource
import com.example.feature.domain.use_cases.UsersUseCases
import com.example.feature.presentation.StateHolder.StateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val getAllUsersUseCases: UsersUseCases) :
    CoreViewModel() {

    val allUsers = executeApi { getAllUsersUseCases.invoke() }.map {
        when (it) {
            is Resource.Loading -> {
                StateHolder(isLoading = true)
            }

            is Resource.Success -> {
                StateHolder(data = it.data)
            }

            is Resource.Error -> {
                StateHolder(error = it.message.toString())
            }
        }
    }
}

