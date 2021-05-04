package hr.fvlahov.barsapp.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Serializer(forClass = Date::class)
object DateSerializer : KSerializer<Date> {
    override fun serialize(output: Encoder, obj: Date) {
        output.encodeString(obj.toString())
    }
    override fun deserialize(input: Decoder): Date {
        val df1: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        return df1.parse(input.decodeString())
    }
}
