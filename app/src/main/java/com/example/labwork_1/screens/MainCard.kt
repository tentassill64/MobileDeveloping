package com.example.labwork_1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.labwork_1.Data.WeatherModel
import com.example.labwork_1.R
import com.example.labwork_1.ui.theme.BlueLight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

@Composable
fun MainCard(currentDate: MutableState<WeatherModel>, onClickSync: () -> Unit,
             onClickSearch: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                contentColor = BlueLight
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = currentDate.value.time,
                            modifier = Modifier.padding(
                                top = 8.dp,
                                start = 8.dp
                            ),
                            style = TextStyle(fontSize = 15.sp),
                            color = Color.White
                        )
                        AsyncImage(
                            model = "https:${currentDate.value.icon}",
                            contentDescription = "im2", modifier = Modifier
                                .size(35.dp)
                                .padding(
                                    top = 3.dp,
                                    end = 8.dp
                                )
                        )
                    }
                }
                Text(
                    text = currentDate.value.city,
                    style = TextStyle(fontSize = 24.sp),
                    color = Color.White
                )
                Text(
                    text = if(currentDate.value.currentTemp.isNotEmpty())
                        currentDate.value.currentTemp
                    else currentDate.value.maxTemp,
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.White
                )
                Text(
                    text = currentDate.value.condition,
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        onClickSearch.invoke();
                    }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_search) ,
                            contentDescription = "im3",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "${currentDate.value.maxTemp}C/${currentDate.value.minTemp}C",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                    IconButton(onClick = {
                        onClickSync.invoke();
                    }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_cloud_sync) ,
                            contentDescription = "im3",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(daysList: MutableState<List<WeatherModel>>, currentDate: MutableState<WeatherModel>) {
    val tabList = listOf("HOURS", "DAYS");
    val pagerState = rememberPagerState();
    val tabIndex = pagerState.currentPage;
    var coroutineScope = rememberCoroutineScope();

    Column(
        modifier = Modifier
            .padding(
                start = 5.dp,
                end = 5.dp
            )
            .clip(RoundedCornerShape(5.dp))
    ) {
        androidx.compose.material.TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = BlueLight,
            contentColor = Color.White,
            indicator = { pos ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, pos)
                )
            },
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }, text = {
                        Text(text = text)
                    }
                )
            }

        }
    }
    HorizontalPager(
        count = tabList.size,
        state = pagerState
    ) { index ->
        val list = when(index) {
            0 -> getWeatherByHours(currentDate.value.hours)
            1 -> daysList.value
            else -> daysList.value
        }
        MainList(list, currentDate)
    }
}

private fun getWeatherByHours(hours: String):List<WeatherModel> {
    if(hours.isEmpty()) return listOf();

    val hoursArray = JSONArray(hours);

    val list = ArrayList<WeatherModel>();

    for( i in 0 until hoursArray.length() ) {
        val item = hoursArray[i] as JSONObject;
        list.add(
            WeatherModel(
                "",
                item.getString("time"),
                item.getString("temp_c") + "C",
                item.getJSONObject("condition").getString("text"),
                item.getJSONObject("condition").getString("icon"),
                "",
                "",
                ""
            )
        )
    }

    return list;
}
