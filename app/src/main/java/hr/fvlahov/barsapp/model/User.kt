package hr.fvlahov.barsapp.model

data class User(var idUser: Int, var username: String, var password: String, var name: String, var isAdmin: Boolean, var bar: Bar) {

}