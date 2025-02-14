package model.admin.response

import java.util.UUID

data class AdminPenaltyResponseModel(
    val myPenaltyPoint: Int,
    val because: String,
    val userId: UUID,
    val penaltyPoint: Int,
    val name: String,
)