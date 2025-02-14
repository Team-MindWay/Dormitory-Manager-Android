package model.myrank.response

import java.util.UUID

data class MyRankResponseModel(
    val userId: UUID,
    val rank: Int,
    val name: String,
    val penaltyPoint: Int,
    val profileImage: String,
)