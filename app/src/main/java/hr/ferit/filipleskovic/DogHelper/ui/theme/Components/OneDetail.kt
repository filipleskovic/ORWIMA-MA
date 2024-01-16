package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.ferit.filipleskovic.DogHelper.data.Breed
import hr.ferit.filipleskovic.DogHelper.ui.theme.Browny

@Composable
fun OneDetail(
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
                fontSize = 27.sp,
            )
        )
        if (breed != null) {
            Text(
                text = breed.returnParametar(text),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp,

                    )
            )
        }

    }
}