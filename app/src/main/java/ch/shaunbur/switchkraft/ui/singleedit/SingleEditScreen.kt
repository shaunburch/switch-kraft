package ch.shaunbur.switchkraft.ui.singleedit

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import ch.shaunbur.switchkraft.EditController
import ch.shaunbur.switchkraft.EditMode
import ch.shaunbur.switchkraft.EditScope
import ch.shaunbur.switchkraft.EditableTextField
import ch.shaunbur.switchkraft.LocalEditController
import ch.shaunbur.switchkraft.ScreenDefinition
import ch.shaunbur.switchkraft.useEditController

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
    val editController = LocalEditController.current
    Column {
        Button(
            onClick = {
                editController.beginEdit()
            }
        ) {
            Text(if (editMode == EditMode.Edit) "Save" else "Edit")
        }
        var value by remember { mutableStateOf("Text") }
        EditScope {
            EditableTextField(
                label = "Editable Field",
                value = value,
                onValueChange = { value = it },
                validator = { it.isNotEmpty() }
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    SingleEditScreen()
}