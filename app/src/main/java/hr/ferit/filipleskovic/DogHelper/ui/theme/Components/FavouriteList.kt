package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import hr.ferit.filipleskovic.DogHelper.Routes
import hr.ferit.filipleskovic.DogHelper.data.Breed
import hr.ferit.filipleskovic.DogHelper.data.BreedViewModel

@Composable
fun FavouriteList(
    nRows: Int,
    nColumns: Int,
    breeds: List<Breed>,
    navigation: NavHostController
) {
    EasyGrid(nRows = nRows, nColumns = nColumns, items = breeds) {
        FavouriteCard(breed = it) {
            navigation.navigate(
                Routes.getRecipeDetailsPath(it.id)
            )
        }
    }
}