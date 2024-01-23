package hr.ferit.filipleskovic.DogHelper.ui.theme.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hr.ferit.filipleskovic.DogHelper.data.BreedViewModel
import hr.ferit.filipleskovic.DogHelper.ui.theme.Browny
import hr.ferit.filipleskovic.DogHelper.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dropbox(
    viewModel: BreedViewModel
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Column(
    ) {
        IconButton(

            onClick = { isExpanded = true },
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.Start)


        ) {
            Icon(
                imageVector = Icons.Filled.Sort,
                contentDescription = null,
                tint = Browny
            )
        }
        DropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            DropdownMenuItem(
                text = { Text(text = "Sort by name") },
                onClick = {
                    isExpanded = false;
                    viewModel.sortByName()

                }

            )
            DropdownMenuItem(
                text = { Text(text = "Sort by sheeding") },
                onClick = {
                    isExpanded = false;
                    viewModel.sortBySheeding()
                })

        }
    }
}
