package remote.dto.admin.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.admin.request.AuthorityRequestModel

@JsonClass(generateAdapter = true)
data class AuthorityRequest(
    @Json(name = "accountIdx") val accountIdx: String,
    @Json(name = "authority") val authority: String
)

fun AuthorityRequestModel.toDto() = AuthorityRequest(
    accountIdx = accountIdx,
    authority = authority
)

fun AuthorityRequest.toModel() = AuthorityRequestModel(
    accountIdx = accountIdx,
    authority = authority
)
