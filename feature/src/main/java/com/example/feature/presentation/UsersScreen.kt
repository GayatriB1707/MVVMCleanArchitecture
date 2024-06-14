package com.example.feature.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.views.ViewStateHandler
import com.example.feature.R
import com.example.feature.domain.entity.UsersEntity

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UsersScreen(usersViewModel: UsersViewModel = hiltViewModel()) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(stringResource(R.string.users_details)) },
            navigationIcon = {
                IconButton(onClick = {  }) {
                    Icon(Icons.Default.Home, contentDescription = stringResource(R.string.back))
                }
            }
        )
    }) {padding->Box(modifier = Modifier.padding(padding)){
        val result = usersViewModel.usersState.value
        if(result.isLoading){
            Box(modifier =Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator(modifier = Modifier.testTag("progress"))
            }
        }
        if(result.data!=null){
            LazyColumn(modifier= Modifier.testTag("Users Details")){
                items(result.data){
                    UserItem(it)
                }
            }
        }
    }

    }
   /* val state = usersViewModel.uiState.collectAsState()

    val allUserItems = usersViewModel.allItems.collectAsState(initial = emptyList()).value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.users_details)) },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Default.Home, contentDescription = stringResource(R.string.back))
                    }
                }
            )
        },
        content = {
            ViewStateHandler<List<UsersEntity>>(viewState = state.value){
                LazyColumn (modifier = Modifier.padding(it)){
                    items(allUserItems){users->
                        UsersCard(usersEntity =users )
                    }
                }
            }
        }
    )
}

@Composable
fun UsersCard(usersEntity: UsersEntity) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .shadow(elevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "User ID: ${usersEntity.userID}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Name: ${usersEntity.userName}",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "UserName: ${usersEntity.userUserName}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Email Id: ${usersEntity.userEmail}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }*/
}