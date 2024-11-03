package com.example.bookappps.presentation.addedit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bookappps.presentation.BookVM
import com.example.bookappps.presentation.components.SortByAuthor
import com.example.bookappps.utils.addOrUpdateBook
import com.example.bookappps.utils.getBooks

class AddEditBookViewModel(bookId: Int = -1) : ViewModel() {

    private val _book = mutableStateOf(BookVM())
    val book: State<BookVM> = _book

    private fun findBook(bookId: Int) {
        _book.value = getBooks(SortByAuthor).find { it.id == bookId } ?: BookVM()
    }

    init {
        findBook(bookId)
    }

    fun onEvent(event: AddEditBookEvent) {
        when (event) {
            is AddEditBookEvent.EnteredAuthor -> {
                _book.value = _book.value.copy(author = event.author)
            }

            is AddEditBookEvent.EnteredTitle -> {
                _book.value = _book.value.copy(title = event.title)
            }

            AddEditBookEvent.BookRead -> _book.value = _book.value.copy(read = !_book.value.read)
            is AddEditBookEvent.TypeChanged -> {
                _book.value = _book.value.copy(bookType = event.bookType)
            }

            AddEditBookEvent.SaveBook -> {
                addOrUpdateBook(book.value)
            }

        }

    }
}

