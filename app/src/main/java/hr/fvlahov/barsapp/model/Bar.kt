package hr.fvlahov.barsapp.model

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Bar(var id: Int, var barName: String, var inventory: Inventory, var users : List<User>, var shifts : List<Shift>) {

}