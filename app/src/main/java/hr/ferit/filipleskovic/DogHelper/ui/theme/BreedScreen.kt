package hr.ferit.filipleskovic.DogHelper.ui.theme

import android.graphics.drawable.Icon
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import hr.ferit.filipleskovic.DogHelper.Routes
import hr.ferit.filipleskovic.DogHelper.data.Breed
import hr.ferit.filipleskovic.DogHelper.data.BreedsRepository
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.Details
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.Header
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.ScreenTitle
import org.w3c.dom.Text


@Composable
fun BreedScreen(
    navigation: NavHostController,
    repository: BreedsRepository,
    breedId: String,

    ) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(LightOragne)
    ) {

        item {

            val breed = repository.breedsData.find { it.id == breedId }
            if (breed != null) {
                Header(navigation = navigation, breed = breed, repository = BreedsRepository())
                ScreenTitle(text = breed.name)
                Image(
                    painter = rememberAsyncImagePainter(model = breed.image),
                    contentDescription = "Breed Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(horizontal = 0.dp)
                )
                Details(breed = breed)


            }

        }
    }

}


@Composable
fun BottomNavigation(
    navigation: NavHostController,

    ) {
    Row(

        modifier = Modifier.fillMaxWidth()
            .background(LightYellow),
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        ActiveButton(name = "Home", icon = Icons.Outlined.Home) {
            navigation.navigate(Routes.SCREEN_ALL_BREEDS)
        }
        ActiveButton(name = "Favourite", icon = Icons.Filled.StarBorder) {
            navigation.navigate(Routes.SCREEN_ALL_BREEDS)
        }
    }

}

@Composable
fun ActiveButton(
    name: String,
    icon: ImageVector,
    onClick: () -> Unit = {},
) {
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
            .background(LightYellow)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Button",
            tint = Browny,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
        )

    Text(
        text = name,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        )
    )
}
}




