package hr.fvlahov.barsapp.model

import hr.fvlahov.barsapp.utils.DateSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Shift(
    var id: Int,
    @Serializable(with = DateSerializer::class)
    var dateTime: Date,
    var shiftDurationHours: Float,
    var shiftStatus: ShiftStatus,
    var worker: User?
) {
}