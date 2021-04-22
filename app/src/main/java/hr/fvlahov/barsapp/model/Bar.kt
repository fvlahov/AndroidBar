package hr.fvlahov.barsapp.model

@kotlinx.serialization.Serializable
data class Bar(var id: Int, var barName: String, var inventory: Inventory, var users : List<User>) {

}