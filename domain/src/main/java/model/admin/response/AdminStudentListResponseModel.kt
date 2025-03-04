package model.admin.response

import java.util.UUID


data class AdminStudentListResponseModel(
    val name: String,
    val penaltyPoint: Int,
    val roomNum: Int,
    val userId: UUID,
)