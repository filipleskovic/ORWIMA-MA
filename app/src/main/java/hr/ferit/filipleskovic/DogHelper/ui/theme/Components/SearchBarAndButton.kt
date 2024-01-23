package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.ferit.filipleskovic.DogHelper.data.BreedViewModel
import hr.ferit.filipleskovic.DogHelper.ui.theme.Brown
import hr.ferit.filipleskovic.DogHelper.ui.theme.Browny
import hr.ferit.filipleskovic.DogHelper.ui.theme.Components.Dropbox
import hr.ferit.filipleskovic.DogHelper.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarAndButton(
    user: String,
    @DrawableRes iconResource: Int,
    labelText: String,
    viewModel: BreedViewModel,
    onClick: () -> Unit = {},
    colors: TextFieldColors = TextFieldDefaults.colors(
        focusedTextColor = Browny,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        unfocusedLabelColor = Browny,
        focusedPlaceholderColor = Browny,
    )
) {
    Column {
        Text(
            modifier = Modifier.padding(
                horizontal = 20.dp
            ),
            text = "Welcome, " + user,
            style = TextStyle(
                color = Browny,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace
            )

        )
        Row {
            var searchInput by remember {
                mutableStateOf("")
            }

            TextField(
                value = searchInput,
                onValueChange = {
                    searchInput = it
                    viewModel.filterByName(searchInput)
                },
                label = {
                    Text(labelText)
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = iconResource),
                        contentDescription = labelText,
                        tint = Browny,
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp)
                    )
                },
                colors = colors,
                modifier = Modifier
                    .width(310.dp)
                    .padding(horizontal = 4.dp)
            )
            Dropbox(viewModel)
        }
    }
}