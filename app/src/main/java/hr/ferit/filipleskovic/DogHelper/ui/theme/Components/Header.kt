package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import hr.ferit.filipleskovic.DogHelper.data.Breed
import hr.ferit.filipleskovic.DogHelper.data.BreedsRepository
import hr.ferit.filipleskovic.DogHelper.ui.theme.Browny

@Composable
fun Header(
    navigation: NavHostController,
    breed: Breed,
    repository: BreedsRepository
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {

        IconButton(modifier = Modifier.padding(10.dp), onClick = { navigation.popBackStack() }

        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Browny,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)

            )
        }

        IconButton(modifier = Modifier.padding(10.dp), onClick = {
            breed.isFavorited = !breed.isFavorited
            repository.updateRecipe(breed)
        }
        ) {
            Icon(
                imageVector = if (breed.isFavorited) Icons.Filled.Star else Icons.Filled.StarOutline,
                contentDescription = "Back",
                tint = Browny,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
            )
        }
    }
}