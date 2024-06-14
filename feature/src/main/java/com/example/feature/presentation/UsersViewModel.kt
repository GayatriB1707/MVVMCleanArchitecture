package com.example.feature.presentation


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.ui.common.Resource
import com.example.feature.domain.use_cases.UsersUseCases
import com.example.feature.presentation.StateHolder.StateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val getAllUsersUseCases: UsersUseCases) :
    ViewModel() {

    private val usersStateHolder = mutableStateOf(StateHolder())
    val usersState : State<StateHolder> = usersStateHolder
    init{
        getUsers()
    }

    private fun getUsers() = viewModelScope.launch{
        getAllUsersUseCases().onEach {
            when(it){
                is Resource.Loading->{
                    usersStateHolder.value = StateHolder(isLoading = true)
                }
                is Resource.Success->{
                    usersStateHolder.value = StateHolder(data = it.data)
                }
                is Resource.Error->{
                usersStateHolder.value = StateHolder(error = it.message.toString())
            }

            }

        }.launchIn(viewModelScope)
    }
}
