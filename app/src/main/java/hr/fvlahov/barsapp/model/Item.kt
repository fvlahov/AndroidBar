package hr.fvlahov.barsapp.model

import java.io.Serializable

data class Item(
    var idItem: Int,
    var name: String,
    var minSupply: Int,
    var unitOfMeasurement: UnitOfMeasurement
) : Serializable{

}