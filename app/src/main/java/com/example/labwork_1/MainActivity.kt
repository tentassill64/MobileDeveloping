package com.example.labwork_1

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.labwork_1.screens.MainCard
import com.example.labwork_1.screens.TabLayout
import com.example.labwork_1.ui.theme.LabWork_1Theme
import org.json.JSONObject

const val API_KEY = "0d29839d68824d3c897212343241211";
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            LabWork_1Theme {
                androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.weather_bg),
                    contentDescription = "im1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.7f),
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    MainCard()
                    TabLayout()
                }
            }
        }
    }
}

private fun getData(city: String, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=" +
            "$API_KEY" +
            "&q=$city" +
            "&days=3" +
            "&aqi=no" +
            "&alerts=no";

    val queue = Volley.newRequestQueue(context);
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        {
                response ->
        },
        {
                error ->
        }
    );
    queue.add(stringRequest);
}
















@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, context: Context) {
    val state = remember {
        mutableStateOf("Unknown")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center) {
            Text(text = "Temp in $name! = ${state.value}")
        }
        Box(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter) {
            Button(onClick = {
                getResult(name, state, context)
            }, modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
            ) {

                Text(text = "Refresh")
            }
        }
    }


}

private fun getResult(city: String, state: MutableState<String>, context: Context) {
    val url = "https://api.weatherapi.com/v1/current.json?key=$API_KEY&q=$city&aqi=no";

    val queue = Volley.newRequestQueue(context);
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        {
            response ->
            val obj = JSONObject(response);
            state.value = obj.getJSONObject("current")
                .getString("temp_c");
        },
        {
            error ->
        }
    );
    queue.add(stringRequest);
}
