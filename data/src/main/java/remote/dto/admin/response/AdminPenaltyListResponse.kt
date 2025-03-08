package remote.dto.admin.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.admin.response.AdminPenaltyListResponseModel

@JsonClass(generateAdapter = true)
data class AdminPenaltyListResponse (
    @Json(name = "pointList") val pointList: Int,
    @Json(name = "because") val because: String,
)
fun AdminPenaltyListResponse.toModel() = AdminPenaltyListResponseModel(
    because = because,
    pointList = pointList,

)