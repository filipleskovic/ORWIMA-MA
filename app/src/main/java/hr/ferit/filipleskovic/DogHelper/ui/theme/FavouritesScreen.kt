package hr.ferit.filipleskovic.DogHelper.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import hr.ferit.filipleskovic.DogHelper.R
import hr.ferit.filipleskovic.DogHelper.data.BreedViewModel
import hr.ferit.filipleskovic.DogHelper.data.BreedsRepository
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.BreedList
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.FavouriteCard
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.FavouriteList
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.ScreenTitle
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.SearchBarAndButton

@Composable
fun FavouritesScreen(
    navigation :NavHostController,
    viewModel: BreedViewModel
) {
    val breeds by viewModel.breeds.collectAsState()
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightOragne)
    )
    {
        item {
            ScreenTitle("Favorites")
            FavouriteList(nRows = 1, nColumns =1 , breeds =breeds , navigation =navigation )

        }
    }
}
