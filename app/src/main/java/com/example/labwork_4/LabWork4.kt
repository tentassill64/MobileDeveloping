package com.example.labwork_4

import android.R
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen() {
    return Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "My First App") },
                navigationIcon = {
                    IconButton(
                        onClick = { /*Unused*/ }) {
                        Icon(Icons.Filled.FavoriteBorder, contentDescription = "Favorite")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceAround
                ) {
                    IconButton(onClick = { /*Unused*/ }) {
                        Icon(Icons.Filled.DateRange,
                            contentDescription = "Date",
                            modifier = Modifier.size(50.dp))
                    }
                    IconButton(onClick = { /*Unused*/ }) {
                        Icon(Icons.Filled.Home,
                            contentDescription = "Home",
                            modifier = Modifier.size(50.dp))
                    }
                    IconButton(onClick = { /*Unused*/ }) {
                        Icon(Icons.Filled.AccountCircle,
                            contentDescription = "Account",
                            modifier = Modifier.size(50.dp))
                    }
                }
            }
        }
    ) {padding ->
        padding
        Column(

            modifier = Modifier
                .fillMaxHeight()
                .padding(padding)

        ){
            Text("Hello! Thats your last chats", modifier = Modifier
                .padding(15.dp),
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            LazyColumn(){
                items(50){
                    chat->
                    Row(

                    ) {
                        Image(painter = painterResource(id = R.mipmap.sym_def_app_icon),
                            contentDescription = "ChatIcon",
                            modifier = Modifier
                            .padding(10.dp)
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(color = Color.Gray)
                        )
                        Column (){
                            Text("Chat number $chat", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
                            Text("That a simple example for chat number $chat. I " +
                                    "just want to see this text on two lines so that you can try to make a restriction")
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = Color.Gray,
                        thickness = 1.dp
                    )
                }
            }

        }
    }
}

@Preview
@Composable
private fun preview() {
    SecondScreen();
}