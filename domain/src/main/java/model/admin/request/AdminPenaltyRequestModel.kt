package model.admin.request

import emumtype.Authority
import java.util.UUID

data class AdminPenaltyRequestModel (
     val penaltyPoint: Int,
     val because: String,
     val accountIdx: UUID,
     val authority: Authority
)