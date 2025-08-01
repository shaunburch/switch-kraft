package ch.shaunbur.switchkraft

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Field(
    value: String,
    onValueChange: (String) -> Unit = {},
    style: TextStyle = TextStyle.Default,
    label: String = ""
) {
    val mode = LocalEditMode.current
    val isEditable = mode == EditMode.Edit

    if (isEditable) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) }
        )
    } else {
        Text(
            text = value,
            style = style
        )
    }
}

@Composable
@Preview
private fun Preview() {
    Field(value = "Sample Text")
}