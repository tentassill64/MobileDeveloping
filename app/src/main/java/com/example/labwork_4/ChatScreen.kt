package com.example.labwork_4

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(navController: NavController, chatId: Int?) {
  Row(

  ) {
      IconButton(
          onClick = {
              navController.popBackStack()
          },
          modifier = Modifier.size(50.dp),
          content = {
            androidx.compose.material3.Icon(Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back")
          }
      )
        Text(text = "Вы открыли чат под номером $chatId")
    }

}