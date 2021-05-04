package hr.fvlahov.barsapp.dal.implementations

import android.util.Log
import hr.fvlahov.barsapp.dal.interfaces.IRepoBar
import hr.fvlahov.barsapp.model.Bar
import hr.fvlahov.barsapp.model.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.decodeFromString
import okhttp3.*
import org.jetbrains.anko.doAsync
import java.io.IOException
import java.lang.Exception
import java.net.URL
import java.nio.charset.Charset

const val URL = "http://10.0.2.2:24517/bar"
const val USERNAME = "?username=";
const val PASSWORD = "password=";

class BarRepo : IRepoBar {

    override fun getBarByUser(userName: String, password: String): Bar {
        val url = "$URL$USERNAME$userName&$PASSWORD$password"

        val apiResponse = URL(url).readText()

        lateinit var obj:Bar
        try {
            obj = Json.decodeFromString<Bar>(apiResponse)
        }
        catch (e : Exception){
            e.printStackTrace()
        }
        return obj
    }
}
