package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.ferit.filipleskovic.DogHelper.ui.theme.Orange

@Composable
fun ScreenTitle(
    text: String
) {
    Text(
        text = text,
        style = TextStyle(
            color = Orange,
            fontSize = 40.sp,
            fontFamily = FontFamily.Monospace
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp)
            .wrapContentSize(Alignment.Center)
    )


}