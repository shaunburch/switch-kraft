package ch.shaunbur.switchkraft.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ch.shaunbur.switchkraft.ScreenDefinition
import ch.shaunbur.switchkraft.ui.singleedit.SingleEditScreen

object HomeScreen : ScreenDefinition {
    override val route: String = "home"
    override val title: String = "Home"
    override val content: @Composable ((NavBackStackEntry, NavController) -> Unit)
        get() = { _, navController ->
            HomeScreen(
                onSingleEdit = { navController.navigate(SingleEditScreen.route) }
            )
        }
}

@Composable
fun HomeScreen(
    onSingleEdit: () -> Unit = {}
) {
    Column {
        Text("Home")
        Button(
            onClick = onSingleEdit,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Go to Single Edit")
        }
    }
}

@Composable
@Preview
private fun Preview() {
    HomeScreen()
}

