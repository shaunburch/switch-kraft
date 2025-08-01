package ch.shaunbur.switchkraft.ui.singleedit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ch.shaunbur.switchkraft.ScreenDefinition

object SingleEditScreen : ScreenDefinition {
    override val route: String = "single"
    override val title: String = "Single Edit"
    override val content: @Composable ((NavBackStackEntry, NavController) -> Unit)
        get() = { _, navController ->
            SingleEditScreen(
                onBack = { navController.popBackStack() }
            )
        }
}

@Composable
fun SingleEditScreen(
    onBack: () -> Unit = {}
) {
    Text("Single Edit")
}

@Composable
@Preview
private fun Preview() {
    SingleEditScreen()
}