package ch.shaunbur.switchkraft

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

enum class EditMode {
    View, Edit
}

val LocalEditMode = compositionLocalOf { EditMode.View }

@Composable
fun EditScope(
    mode: EditMode,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalEditMode provides mode) {
        content()
    }
}