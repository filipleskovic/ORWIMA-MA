package hr.ferit.filipleskovic.DogHelper.data

data class Breed(
    var id: String = "",
    val image: String="",
    val name: String= "",
    val weight: String="",
    val height: String= "",
    val lifespan: String="",
    var isFavorited: Boolean=false,
    val intelligence : Int =0,
    val loveDogs: Int =0,
    val loveKids: Int =0,
    val loveAnimals: Int =0,
    val sheeding:Int =0,
    val activity: Int=0,
    val hairType: String="",



)
{
    fun returnParametar(parametar:String):String
    {
        val result = when (parametar) {
            "Weight" -> weight
            "Height" -> height
            "Lifespan" -> lifespan
            "HairType"->hairType
            else -> isFavorited.toString()
        }
        return result
    }
    fun returnStars(parametar: String):Int {
        val result = when (parametar) {
            "Intelligence" -> intelligence
            "LoveKids" -> loveKids
            "LoveAnimals"->loveAnimals
            "LoveDogs"->loveDogs
            "Activity"->activity
            "Sheeding"->sheeding
            else-> 0

        }
        return result
    }
}
