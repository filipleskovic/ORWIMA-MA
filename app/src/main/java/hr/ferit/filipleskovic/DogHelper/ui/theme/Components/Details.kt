package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hr.ferit.filipleskovic.DogHelper.data.Breed
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.OneDetail
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.OneDetailStars

@Composable
fun Details(
    breed: Breed?,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column {
            OneDetail(breed = breed, text = "Height")
            OneDetail(breed = breed, text = "Weight")
            OneDetailStars(breed = breed, text = "Intelligence")
            OneDetailStars(breed = breed, text = "Activity")
            OneDetailStars(breed = breed, text = "Sheeding")
        }
        Column {
            OneDetail(breed = breed, text = "Lifespan")
            OneDetail(breed = breed, text = "HairType")
            OneDetailStars(breed = breed, text = "LoveAnimals")
            OneDetailStars(breed = breed, text = "LoveKids")
            OneDetailStars(breed = breed, text = "LoveDogs")

        }
    }


}
