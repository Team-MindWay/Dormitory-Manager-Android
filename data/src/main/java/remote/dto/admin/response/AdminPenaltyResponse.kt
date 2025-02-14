package remote.dto.admin.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.admin.response.AdminPenaltyResponseModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class AdminPenaltyResponse (
    @Json(name = "MyPenaltyPoint") val myPenaltyPoint: Int,
    @Json(name = "because") val because: String,
    @Json(name = "UserId") val userId: UUID,
    @Json(name = "PenaltyPoint") val penaltyPoint: Int,
    @Json(name = "Name") val name: String,
)
fun AdminPenaltyResponse.toModel() = AdminPenaltyResponseModel(
    myPenaltyPoint = myPenaltyPoint,
    because = because,
    userId = userId,
    penaltyPoint = penaltyPoint,
    name = name
)