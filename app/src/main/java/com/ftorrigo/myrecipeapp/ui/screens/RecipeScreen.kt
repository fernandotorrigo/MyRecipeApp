package com.ftorrigo.myrecipeapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ftorrigo.myrecipeapp.ui.components.CategorySection
import com.ftorrigo.myrecipeapp.ui.viewmodels.MainViewModel

@Composable
fun RecipeScreen() {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }

            else -> {
                CategorySection(categories = viewState.list)
            }
        }
    }
}
