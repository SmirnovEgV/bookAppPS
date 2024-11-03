package com.example.bookappps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.bookappps.presentation.addedit.AddEditBookScreen
import com.example.bookappps.presentation.addedit.AddEditBookViewModel
import com.example.bookappps.presentation.list.ListBooksScreen
import com.example.bookappps.presentation.list.ListBooksViewModel
import com.example.bookappps.ui.theme.BooksTheme
import com.example.bookappps.utils.AddEditBooksScreen
import com.example.bookappps.utils.BooksListScreen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BooksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = BooksListScreen,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<BooksListScreen> {
                            val books = viewModel<ListBooksViewModel>()
                            ListBooksScreen(navController, books)
                        }
                        composable<AddEditBooksScreen> { navBackStackEntry ->

                            val args: AddEditBooksScreen = navBackStackEntry.toRoute<AddEditBooksScreen>()

                            val book = viewModel<AddEditBookViewModel>() {
                                AddEditBookViewModel(args.bookId)
                            }
                            AddEditBookScreen(navController, book)
                        }
                    }

                }
            }
        }
    }
}

