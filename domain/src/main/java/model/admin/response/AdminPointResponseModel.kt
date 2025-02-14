package model.admin.response

import java.util.UUID

data class AdminPointResponseModel(
    val userId: UUID,
    val cleanPoint: Int,
    val name: String,
    val toDayClean: String
)