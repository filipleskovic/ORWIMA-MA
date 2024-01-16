package hr.ferit.filipleskovic.DogHelper.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.ferit.filipleskovic.DogHelper.R
import hr.ferit.filipleskovic.DogHelper.ui.theme.Orange


@Preview
@Composable
fun FirstScreen(
){

    Logo(R.drawable.wave_cute,"DogHelper")
}

@Composable
fun Logo(
    @DrawableRes logo:Int,
    text:String
){
        Image(
            painter = painterResource(id = logo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
                .background(color = Color.LightGray)
                )
        Text(
        text=text,
        style = TextStyle(
            color = Orange,
            fontStyle= FontStyle.Italic,
            fontSize = 60.sp,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp)
            .wrapContentSize(Alignment.Center)
        )

}
