package hr.ferit.filipleskovic.DogHelper

import androidx.compose.runtime.Composable
import hr.ferit.filipleskovic.DogHelper.data.BreedsRepository
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.ferit.filipleskovic.DogHelper.data.Breed
import hr.ferit.filipleskovic.DogHelper.data.BreedViewModel
import hr.ferit.filipleskovic.DogHelper.ui.theme.BreedScreen
import hr.ferit.filipleskovic.DogHelper.ui.theme.HomeScreen



@Composable
fun NavigationController(
    repository: BreedsRepository
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination =
        Routes.SCREEN_ALL_BREEDS
    ) {
        composable(Routes.SCREEN_ALL_BREEDS) {
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
            HomeScreen(navigation = navController, viewModel = BreedViewModel(repository))
        }
    }
}