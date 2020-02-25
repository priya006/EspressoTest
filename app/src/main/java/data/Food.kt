package data

data class Food (
    val id: Int,
    val title: String,
    val description: String,
    val chef: ArrayList<String>?,
    val menu: ArrayList<String>?
)