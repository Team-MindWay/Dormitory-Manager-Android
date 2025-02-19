package model.rank.response

import java.util.UUID

data class RankResponseModel(
    val userId: UUID,
    val rank: Int,
    val name: String,
    val penaltyPoint: Int,
    val roomNum: Int,
)