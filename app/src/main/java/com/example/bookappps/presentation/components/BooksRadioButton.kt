package com.example.bookappps.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BooksRadioButton(text: String, selected: Boolean, onSelect: () -> Unit, modifier: Modifier = Modifier) {
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selected,
            onClick = onSelect,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, style = TextStyle(fontSize = 20.sp))
    }
}

@Preview
@Composable
fun BooksRadioButtonPreview() {
    BooksRadioButton(text = "Author", selected = true, onSelect = {  })
}