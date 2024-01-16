package hr.ferit.filipleskovic.DogHelper

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.ferit.filipleskovic.DogHelper.data.BreedViewModel
import hr.ferit.filipleskovic.DogHelper.data.BreedsRepository
import hr.ferit.filipleskovic.DogHelper.ui.theme.BottomNavigation
import hr.ferit.filipleskovic.DogHelper.ui.theme.BreedScreen
import hr.ferit.filipleskovic.DogHelper.ui.theme.FavouritesScreen
import hr.ferit.filipleskovic.DogHelper.ui.theme.HomeScreen

object Routes {
    const val SCREEN_ALL_BREEDS = "breedList"
    const val SCREEN_BREED_DETAILS = "breedDetails/{breedId}"
    const val SCREEN_FAVOURITE_BREEDS = "favouriteList"
    fun getRecipeDetailsPath(breedId: String): String {
        return "breedDetails/$breedId"
    }
}

@Composable
fun MainScreen(
    repository: BreedsRepository
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(navigation = navController)
        }
    ) { innerPadding ->
        Surface(
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier
                .fillMaxSize()
        ) {

            NavHost(
                navController = navController,
                startDestination = Routes.SCREEN_ALL_BREEDS,
                modifier=Modifier.padding(innerPadding)
            ) {
                composable(Routes.SCREEN_ALL_BREEDS) {
                    Log.d("krc ima naocale","jel jesam")
                    HomeScreen(navigation = navController, viewModel = BreedViewModel(repository))
                }
                composable(
                    Routes.SCREEN_BREED_DETAILS,
                    arguments = listOf(
                        navArgument("breedId") {
                            type = NavType.StringType
                        }
                    )
                ) { backStackEntry ->
                    backStackEntry.arguments?.getString("breedId")?.let {
                        BreedScreen(
                            repository = repository,
                            navigation = navController,
                            breedId = it
                        )
                    }
                }
                composable(Routes.SCREEN_FAVOURITE_BREEDS) {
                    FavouritesScreen(navigation= navController, viewModel = BreedViewModel(repository))                }
            }
        }

    }
}