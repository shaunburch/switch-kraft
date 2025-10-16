package ch.shaunbur.switchkraft

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EditableTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    validator: (String) -> Boolean = { true }
) {
    val controller = useEditController()
    var internalValue by remember { mutableStateOf(value) }
    val isEditable = controller.mode == EditMode.Edit

    val handle = remember {
        object : EditableFieldHandle {
            override fun validate(): Boolean = validator(internalValue)
            override fun revert() { internalValue = value }
        }
    }

    DisposableEffect(Unit) {
        controller.register(handle)
        onDispose { controller.unregister(handle) }
    }

    if (isEditable) {
        TextField(
            value = internalValue,
            onValueChange = { internalValue = it },
            label = { Text(label) }
        )
    } else {
        Text(internalValue)
    }

    // You can choose whether to call onValueChange only on confirm
}

@Composable
@Preview
private fun Preview() {
    EditableTextField(
        label = "Editable Field",
        value = "Initial Value",
        onValueChange = {}
    )
}