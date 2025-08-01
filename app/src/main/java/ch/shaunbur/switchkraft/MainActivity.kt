@file:OptIn(ExperimentalMaterial3Api::class)

package ch.shaunbur.switchkraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ch.shaunbur.switchkraft.ui.home.HomeScreen
import ch.shaunbur.switchkraft.ui.theme.SwitchKraftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            // Get the current screen based on route
            val currentScreen = ScreenRegistry.screens.find {
                it.route == navBackStackEntry?.destination?.route
            }

            SwitchKraftTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = currentScreen?.title.orEmpty()) }
                        )
                    },
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = HomeScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        ScreenRegistry.screens.forEach { screen ->
                            composable(screen.route) { backStackEntry ->
                                screen.content(backStackEntry, navController)
                            }
                        }
                    }
                }
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
    SwitchKraftTheme {
        Greeting("Android")
    }
}