package remote.dto.admin.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.admin.request.AdminCleanRequestModel

@JsonClass(generateAdapter = true)
data class AdminCleanRequest(
    @Json(name = "toDayClean") val toDayClean: String,
    @Json(name = "cleanPoint") val cleanPoint: Int,
)

fun AdminCleanRequestModel.toDto() = AdminCleanRequest(
    toDayClean = toDayClean,
    cleanPoint = cleanPoint,
)

fun AdminCleanRequest.toModel() = AdminCleanRequestModel(
    toDayClean = toDayClean,
    cleanPoint = cleanPoint,
)

