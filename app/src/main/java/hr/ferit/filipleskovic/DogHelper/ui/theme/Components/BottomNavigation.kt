package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import hr.ferit.filipleskovic.DogHelper.Routes
import hr.ferit.filipleskovic.DogHelper.ui.theme.Browny
import hr.ferit.filipleskovic.DogHelper.ui.theme.LightYellow

@Composable
fun BottomNavigation(
    navigation: NavHostController,

    ) {
    Row(

        modifier = Modifier
            .fillMaxWidth()
            .background(LightYellow),
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        ActiveButton(name = "Home", icon = Icons.Outlined.Home) {
            navigation.navigate(Routes.SCREEN_ALL_BREEDS)
        }
        ActiveButton(name = "Favourite", icon = Icons.Filled.StarBorder) {
            navigation.navigate(Routes.SCREEN_FAVOURITE_BREEDS)
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
        modifier = Modifier
            .clickable { onClick() }
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