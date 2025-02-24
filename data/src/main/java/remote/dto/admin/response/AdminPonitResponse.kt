package remote.dto.admin.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.admin.response.AdminPointResponseModel
import model.admin.response.AdminUserResponseModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class AdminPonitResponse (
    @Json(name = "userId") val userId: UUID,
    @Json(name = "cleanPoint") val cleanPoint: Int,
    @Json(name = "name") val name: String,
    @Json(name = "toDayClean") val toDayClean: String
)

fun AdminPonitResponse.toModel() = AdminPointResponseModel(
    userId = userId,
    cleanPoint = cleanPoint,
    name = name,
    toDayClean = toDayClean
)