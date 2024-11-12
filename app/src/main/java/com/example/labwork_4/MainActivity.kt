package com.example.labwork_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labwork_4.NavigationScreens.Screens
import com.example.labwork_4.ui.theme.LabWork_1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork_1Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AppNavigation();
                }
            }
        }
    }

    @Composable
    internal fun AppNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController,
            startDestination = Screens.MainScreen.screenName) {
            composable(
                Screens.ChatScreen.screenName + "/{chatId}",
                arguments = listOf(navArgument("chatId")
                {type = NavType.IntType})
            ){
                    navBackStack -> ChatScreen(navController = navController,
                navBackStack.arguments?.getInt("chatId"))
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabWork_1Theme {
        Greeting("Android")
    }
}