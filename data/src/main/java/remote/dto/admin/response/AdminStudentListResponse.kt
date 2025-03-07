package remote.dto.admin.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.admin.response.AdminStudentListResponseModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class AdminStudentListResponse (
    @Json(name = "name") val name: String,
    @Json(name = "penaltyPoint") val penaltyPoint: Int,
    @Json(name = "roomNum") val roomNum: Int,
    @Json(name = "userId") val userId: UUID,
)

fun AdminStudentListResponse.toModel() = AdminStudentListResponseModel(
    name = name,
    penaltyPoint = penaltyPoint,
    roomNum = roomNum,
    userId = userId,
)