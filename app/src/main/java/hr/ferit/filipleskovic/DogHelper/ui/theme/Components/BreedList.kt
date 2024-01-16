package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import hr.ferit.filipleskovic.DogHelper.Routes
import hr.ferit.filipleskovic.DogHelper.data.Breed
import hr.ferit.filipleskovic.DogHelper.ui.theme.LightOragne
import hr.ferit.filipleskovic.DogHelper.ui.theme.LightYellow

@Composable
fun <T> EasyGrid(nColumns: Int, items: List<T> , content: @Composable (T) -> Unit) {
    Column(
        Modifier
            .padding(16.dp)
    ) {
        for (i in items.indices step 2) {
            Row(
                modifier = Modifier.background(color = LightYellow)
            ) {
                for (j in 0 until nColumns) {
                    if (i + j < items.size) {
                        Box(
                            contentAlignment = Alignment.TopCenter,
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            content(items[i + j])
                        }
                    } else {
                        Spacer(
                            Modifier
                                .weight(1f, fill = true)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun BreedList(
    breeds: List<Breed>,
    navigation: NavHostController
) {
    EasyGrid(nColumns = 2, items = breeds) {
        BreedCard( it.image, it.name)
        {
            navigation.navigate(
                Routes.getRecipeDetailsPath(it.id)
            )
        }
    }
}