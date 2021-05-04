package hr.fvlahov.barsapp.dal.implementations

import hr.fvlahov.barsapp.dal.interfaces.IRepoShifts
import hr.fvlahov.barsapp.model.Bar
import hr.fvlahov.barsapp.model.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.lang.Exception
import java.net.URL

const val SHIFTS = "shifts";


class ShiftsRepo : IRepoShifts {
    override fun getShifts(user: User) {
        val url = "$URL$SHIFTS$USERNAME${user.username}&$PASSWORD${user.password}"

        val apiResponse = URL(url).readText()

        lateinit var obj: Bar
        try {
            obj = Json.decodeFromString<Bar>(apiResponse)
        }
        catch (e : Exception){
            e.printStackTrace()
        }
    }
}