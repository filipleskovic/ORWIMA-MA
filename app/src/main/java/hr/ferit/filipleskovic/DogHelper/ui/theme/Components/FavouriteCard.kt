package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import hr.ferit.filipleskovic.DogHelper.data.Breed
import hr.ferit.filipleskovic.DogHelper.ui.theme.Browny
import hr.ferit.filipleskovic.DogHelper.ui.theme.LightYellow

@Composable
fun FavouriteCard(
    breed:Breed,
    onClick: () -> Unit
) {
    Row(

        modifier=Modifier.fillMaxWidth().height(150.dp)
            .padding(10.dp)
            .background(LightYellow)
            .border(2.dp, color = Browny, shape = RoundedCornerShape(10.dp))

    ){
        Image(
        painter = rememberAsyncImagePainter(model=breed.image),
        modifier = Modifier.size(width = 180.dp, height = 150.dp)
            .border(2.dp,color=Color.Transparent,shape = RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp)),
        contentDescription = "Breed image",
        contentScale = ContentScale.Crop,
        )
        Column(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween

        ){
            Text(text = breed.name, style = TextStyle(color = Browny, fontSize = 20.sp))
            Text(text = "Weight: "+breed.weight,style = TextStyle(color = Browny))
            Text(text = "Height: "+breed.height,style = TextStyle(color = Browny))
            Text(text = "Lifespan: "+breed.lifespan,style = TextStyle(color = Browny))


        }
    }

}