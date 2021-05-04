package hr.fvlahov.barsapp.model

import java.io.Serializable

@kotlinx.serialization.Serializable
data class User(var id: Int, var username: String, var password: String, var name: String, var isAdmin: Boolean){

}