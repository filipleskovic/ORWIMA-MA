package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import hr.ferit.filipleskovic.DogHelper.ui.theme.Brown
import hr.ferit.filipleskovic.DogHelper.ui.theme.LightOragne
import hr.ferit.filipleskovic.DogHelper.ui.theme.LightYellow

@Composable
fun BreedCard(
    imageResource: String,
    name: String,
    onClick: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .size(width = 180.dp, height = 180.dp)
            .clickable { onClick() }
            .background(color = LightOragne)
            .padding(4.dp),
        shape = RoundedCornerShape(10.dp)


    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LightYellow)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = imageResource),
                modifier = Modifier.size(width = 180.dp, height = 150.dp),

                contentDescription = "Breed image",
                contentScale = ContentScale.Crop,
            )
            Text(
                text = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                style = TextStyle(
                    color = Brown,
                    fontSize = 18.sp,
                    background = LightYellow
                )

            )
        }
    }
}