package com.example.feature.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature.R
import com.example.feature.presentation.StateHolder.StateHolder

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UsersScreen(usersViewModel: UsersViewModel = hiltViewModel()) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(stringResource(R.string.users_details)) },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Home, contentDescription = stringResource(R.string.back))
                }
            }
        )
    }) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            val result = usersViewModel.allUsers.collectAsState(
                initial = StateHolder(
                    isLoading = true,
                    data = emptyList()
                )
            ).value
            if (result.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.testTag("progress"))
                }
            }
            if (result.data != null) {
                LazyColumn(modifier = Modifier.testTag("Users Details")) {
                    items(result.data) {
                        UserItem(it)
                    }
                }
            }
        }

    }
}