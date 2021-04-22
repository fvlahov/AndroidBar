package hr.fvlahov.barsapp.model

import java.io.Serializable

@kotlinx.serialization.Serializable
data class Item(
    var id: Int,
    var name: String,
    var minSupply: Int,
    var currentSupply: Int,
    var unitOfMeasurement: UnitOfMeasurement
) : Serializable {

}