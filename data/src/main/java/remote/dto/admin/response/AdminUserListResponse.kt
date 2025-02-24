package remote.dto.admin.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.admin.response.AdminUserListResponseModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class AdminUserListResponse (
    @Json(name = "name") val name: String,
    @Json(name = "penaltyPoint") val penaltyPoint: Int,
    @Json(name = "role") val role: String,
    @Json(name = "userId") val userId: UUID,
    )


fun AdminUserListResponse.toModel() = AdminUserListResponseModel(
    name = name,
    penaltyPoint = penaltyPoint,
    role = role,
    userId = userId,
)