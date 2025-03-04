package remote.dto.admin.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import emumtype.Authority
import model.admin.request.AdminCleanRequestModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class AdminCleanRequest(
    @Json(name = "toDayClean") val toDayClean: String,
    @Json(name = "cleanPoint") val cleanPoint: Int,
    @Json(name = "accountIdx") val accountIdx: UUID,
    @Json(name = "authority") val authority: Authority,
)

fun AdminCleanRequestModel.toDto() = AdminCleanRequest(
    toDayClean = toDayClean,
    cleanPoint = cleanPoint,
    accountIdx = accountIdx,
    authority = authority
)

fun AdminCleanRequest.toModel() = AdminCleanRequestModel(
    toDayClean = toDayClean,
    cleanPoint = cleanPoint,
    accountIdx = accountIdx,
    authority = authority
)

