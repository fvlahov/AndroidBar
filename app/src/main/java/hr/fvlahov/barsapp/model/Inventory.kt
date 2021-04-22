package hr.fvlahov.barsapp.model

@kotlinx.serialization.Serializable
data class Inventory (var id: Int, var items: List<Item>) {
}