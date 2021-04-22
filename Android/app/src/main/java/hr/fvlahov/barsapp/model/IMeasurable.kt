package hr.fvlahov.barsapp.model

interface IMeasurable {
    fun getCorrectMeasure(quantity: Int?) : String
}