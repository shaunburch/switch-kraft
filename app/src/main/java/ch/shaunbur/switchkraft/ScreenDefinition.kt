package ch.shaunbur.switchkraft

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

interface ScreenDefinition {
    val route: String
    val title: String
//    val topBar: @Composable (() -> Unit)?
//    val fab: @Composable (() -> Unit)?
    val content: @Composable (NavBackStackEntry, NavController) -> Unit
}

