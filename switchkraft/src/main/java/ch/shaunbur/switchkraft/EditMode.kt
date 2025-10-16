package ch.shaunbur.switchkraft

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

enum class EditMode {
    View,
    Edit,
    Confirming,
    Disabled
}