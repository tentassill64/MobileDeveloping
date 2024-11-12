package com.example.labwork_1.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.labwork_1.R
import com.example.labwork_1.ui.theme.BlueLight

@Preview (showBackground = true)
@Composable
fun MainScreen() {
    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.weather_bg),
        contentDescription = "im1",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.7f),
        contentScale = ContentScale.FillBounds)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
     Card(onClick = { /*TODO*/ },
         modifier = Modifier.fillMaxWidth(),
         colors = CardDefaults.cardColors(
             contentColor = BlueLight
         ),
            elevation = CardDefaults.cardElevation(
             defaultElevation = 0.dp),
         shape = RoundedCornerShape(10.dp)
     ) {
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Row(modifier =  Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
          ) {
              Text(text = "20 Jun 2024 13:00",
                  modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                  style = TextStyle(fontSize = 15.sp),
                  color = Color.White
              )
              AsyncImage(model = "https://cdn.weatherapi.com/weather/64x64/night/116.png",
                  contentDescription =  "im2", modifier = Modifier
                      .size(35.dp)
                      .padding(top = 3.dp, end = 8.dp))
          }
        }
     }
    }
}