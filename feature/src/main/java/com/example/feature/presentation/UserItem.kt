package com.example.feature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.feature.domain.entity.UsersEntity

@Composable
fun UserItem(usersEntity: UsersEntity) {
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
    }
}
