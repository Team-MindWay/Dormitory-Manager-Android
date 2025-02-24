package model.users.response

import java.util.UUID

data class UsersResponseModel (
     val userId: UUID,
     val cleanPoint: Int,
     val todayClean: String,
     val name: String,
     val penaltyPoint: Int,
     val myBecause: String,
     val because: String,
     val pointList: Int,
     val roomNum: Int,
)