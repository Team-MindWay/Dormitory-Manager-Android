package remote.dto.users.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.users.response.UsersResponseModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class UsersResponse (
    @Json(name = "userId") val userId: UUID,
    @Json(name = "clean-Point") val cleanPoint: Int,
    @Json(name = "to-day-Clean") val todayClean: String,
    @Json(name = "name") val name: String,
    @Json(name = "penalty-Point") val penaltyPoint: Int,
    @Json(name = "Mybecause") val Mybecause: String,
    @Json(name = "because") val because: String,
    @Json(name = "Point-List") val PointList: Int,

)

fun UsersResponse.toModel() = UsersResponseModel(
    userId = userId,
    cleanPoint = cleanPoint,
    todayClean = todayClean,
    name = name,
    penaltyPoint = penaltyPoint,
    Mybecause = Mybecause,
    because = because,
    PointList = PointList

)