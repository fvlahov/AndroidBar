package hr.fvlahov.barsapp.model

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Inventory (var id: Int, var items: List<Item>){
}