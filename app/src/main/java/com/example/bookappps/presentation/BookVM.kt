package com.example.bookappps.presentation

import androidx.compose.ui.graphics.Color
import com.example.bookappps.ui.theme.Purple40
import com.example.bookappps.ui.theme.Purple80
import com.example.bookappps.ui.theme.PurpleGrey40
import com.example.bookappps.ui.theme.PurpleGrey80
import kotlin.random.Random

data class BookVM(
    val id: Int = Random.nextInt(),
    val title: String = "",
    val author: String = "",
    val read: Boolean = false,
    val bookType: BookType = Fiction
)

sealed class BookType(val backgroundColor: Color, val foregroundColor: Color)
data object Fiction: BookType(Purple80, PurpleGrey40)
data object NonFiction: BookType(Purple40, PurpleGrey80)




