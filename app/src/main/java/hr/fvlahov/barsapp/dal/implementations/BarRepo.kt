package hr.fvlahov.barsapp.dal.implementations

import hr.fvlahov.barsapp.dal.interfaces.IRepoBar
import hr.fvlahov.barsapp.model.Bar
import hr.fvlahov.barsapp.model.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.net.URL
const val URL = "http://localhost:24517/bar?"
const val USERNAME = "username=";
const val PASSWORD = "password=";

class BarRepo : IRepoBar{
    override fun getBarByUser(userName: String, password: String): Bar {
        val apiResponse = URL("$URL$USERNAME$userName&$PASSWORD$password").readText()
        val obj = Json.decodeFromString<Bar>(apiResponse)
        return obj
    }
}