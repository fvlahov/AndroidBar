package hr.fvlahov.barsapp.model

@kotlinx.serialization.Serializable
data class User(var idUser: Int, var username: String, var password: String, var name: String, var isAdmin: Boolean, var bar: Bar) {

}