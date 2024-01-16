package hr.ferit.filipleskovic.DogHelper.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class BreedViewModel(repository: BreedsRepository) : ViewModel() {
    private val _breeds: MutableStateFlow<List<Breed>> = MutableStateFlow(emptyList())

    val breeds: StateFlow<List<Breed>> = _breeds.asStateFlow()

    init {
        viewModelScope.launch {
            repository.fetchBreed().collect{
                _breeds.value=it
            }

        }
    }

    fun sortByName() {
        _breeds.update { _breeds.value.sortedBy { it.name } }
    }
    fun sortBySheeding() {
        _breeds.update { _breeds.value.sortedBy { it.sheeding } }
    }
}