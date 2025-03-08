package remote.dto.admin.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import emumtype.Authority
import model.admin.request.AdminPenaltyRequestModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class AdminPenaltyRequest (
    @Json(name = "penaltyPoint") val penaltyPoint: Int,
    @Json(name = "because") val because: String,
    @Json(name = "accountIdx") val accountIdx: UUID,
    @Json(name = "authority") val authority: Authority
)

fun AdminPenaltyRequestModel.toDto() = AdminPenaltyRequest(
    because = because,
    penaltyPoint = penaltyPoint,
    accountIdx = accountIdx,
    authority = authority
)

fun AdminPenaltyRequest.toModel() = AdminPenaltyRequestModel(
    because = because,
    penaltyPoint = penaltyPoint,
    accountIdx = accountIdx,
    authority = authority
)