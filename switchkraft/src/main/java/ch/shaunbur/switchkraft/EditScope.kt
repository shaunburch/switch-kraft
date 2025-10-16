package ch.shaunbur.switchkraft

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember

// TODO Where should this live?
val LocalEditMode = compositionLocalOf { EditMode.View }

@Composable
fun EditScope(
    controller: EditController = remember { EditController() },
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalEditController provides controller) {
        content()
    }
}
