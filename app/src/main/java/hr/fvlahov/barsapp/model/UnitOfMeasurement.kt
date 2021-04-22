package hr.fvlahov.barsapp.model

enum class UnitOfMeasurement () : IMeasurable {
    BOTTLE (){
        override fun getCorrectMeasure(quantity: Int?): String = if(quantity in 2..4) "boce" else "boca"
    },
    KG (){
        override fun getCorrectMeasure(quantity: Int?): String = "Kg"

    },
    LITRE (){
        override fun getCorrectMeasure(quantity: Int?): String = if(quantity in 2..4) "litre" else if(quantity == 1) "litra" else "litara"
    }
}