package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.ferit.filipleskovic.DogHelper.data.Breed
import hr.ferit.filipleskovic.DogHelper.ui.theme.Browny

@Composable
fun OneDetailStars(
    breed: Breed?,
    text: String,
) {
    Column(
        modifier = Modifier.padding(7.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Browny,
                fontSize = 28.sp,
            )
        )
        Row(

        ) {
            if (breed != null) {
                for (i in 0 until breed.returnStars(text))
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star",
                        tint = Browny,
                    )
            }
        }

    }
}