package remote.dto.admin.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.admin.request.AdminPenaltyRequestModel
import model.admin.response.AdminPenaltyResponseModel

@JsonClass(generateAdapter = true)
data class AdminPenaltyRequest (
    @Json(name = "penaltyPoint") val penaltyPoint: Int,
    @Json(name = "because") val because: String,
)

fun AdminPenaltyRequestModel.toDto() = AdminPenaltyRequest(
    because = because,
    penaltyPoint = penaltyPoint,
)

fun AdminPenaltyRequest.toModel() = AdminPenaltyRequestModel(
    because = because,
    penaltyPoint = penaltyPoint,
)