package hr.ferit.filipleskovic.DogHelper.data

import androidx.compose.runtime.mutableStateListOf
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await


class BreedsRepository {
    private val db = Firebase.firestore

    val breedsData = mutableStateListOf<Breed>()
    init {
        fetchDatabaseData()
    }

    private fun fetchDatabaseData() {
        db.collection("breed")
            .get()
            .addOnSuccessListener { result ->
                for (data in result.documents) {
                    val breed = data.toObject(Breed::class.java)
                    if (breed != null) {
                        breed.id = data.id
                        breedsData.add(breed)
                    }
                }
            }
    }

    fun updateRecipe(breed: Breed) {
        db.collection("breed")
            .document(breed.id)
            .set(breed)
    }

    fun fetchBreed(): Flow<List<Breed>> = flow {

        val breeds = mutableListOf<Breed>()
        val items = db.collection("breed").get().await()
        for (item in items) {
            val breed = item.toObject(Breed::class.java)
            if (breed != null) {
                breed.id = item.id
                breeds.add(breed)
            }

        }
        emit(breeds)
    }

}


