package model.admin.response

import java.util.UUID

data class AdminUserListResponseModel(
    val name: String,
    val penaltyPoint: Int,
    val role: String,
    val userId: UUID,
    val roomNum: Int
)