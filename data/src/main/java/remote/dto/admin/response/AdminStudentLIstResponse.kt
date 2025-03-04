package remote.dto.admin.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.admin.response.AdminStudentListResponseModel
import java.util.UUID

@JsonClass(generateAdapter = true)
data class AdminStudentLIstResponse (
    @Json(name = "name") val name: String,
    @Json(name = "penaltyPoint") val penaltyPoint: Int,
    @Json(name = "roomNum") val roomNum: Int,
    @Json(name = "userId") val userId: UUID,
)


fun AdminStudentLIstResponse.toModel() = AdminStudentListResponseModel(
    name = name,
    penaltyPoint = penaltyPoint,
    roomNum = roomNum,
    userId = userId,
)