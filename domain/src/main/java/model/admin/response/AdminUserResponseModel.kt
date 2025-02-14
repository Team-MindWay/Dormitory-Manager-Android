package model.admin.response

import java.util.UUID


data class AdminUserResponseModel (
     val name: String,
     val toDayClean: String,
     val cleanPoint: Int,
     val userId: UUID,
)