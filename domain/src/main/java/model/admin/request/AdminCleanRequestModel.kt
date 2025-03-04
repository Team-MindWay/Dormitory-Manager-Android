package model.admin.request

import emumtype.Authority
import java.util.UUID

data class AdminCleanRequestModel(
     val toDayClean: String,
     val cleanPoint: Int,
     val accountIdx:UUID,
     val authority: Authority
)