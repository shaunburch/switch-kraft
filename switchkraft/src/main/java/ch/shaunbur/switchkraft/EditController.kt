package ch.shaunbur.switchkraft

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf

class EditController(
    initialMode: EditMode = EditMode.View
) {
    var mode by mutableStateOf(initialMode)
        private set

    private val _fields = mutableStateListOf<EditableFieldHandle>()

    fun beginEdit() {
        mode = EditMode.Edit
    }

    fun confirmEdit(): Boolean {
        val isValid = _fields.all { it.validate() }
        if (isValid) mode = EditMode.View
        return isValid
    }

    fun cancelEdit() {
        _fields.forEach { it.revert() }
        mode = EditMode.View
    }

    internal fun register(handle: EditableFieldHandle) {
        _fields += handle
    }

    internal fun unregister(handle: EditableFieldHandle) {
        _fields -= handle
    }
}

val LocalEditController = staticCompositionLocalOf<EditController?> { null }

@Composable
fun useEditController(): EditController {
    return checkNotNull(LocalEditController.current) {
        "Editable field used outside of EditScope"
    }
}