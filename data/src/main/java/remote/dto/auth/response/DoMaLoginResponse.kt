package remote.dto.auth.response

import model.auth.response.DoMaLoginResponseModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import emumtype.Authority

@JsonClass(generateAdapter = true)
data class DoMaLoginResponse(
    @Json(name = "accessToken") val accessToken: String,
    @Json(name = "refreshToken") val refreshToken: String,
    @Json(name = "accessTokenExpiresIn") val accessTokenExpiresIn: String,
    @Json(name = "refreshTokenExpiresIn") val refreshTokenExpiresIn: String,
    @Json(name = "Authority") val authority: Authority
)

fun DoMaLoginResponseModel.toLogin()= DoMaLoginResponseModel(
    accessToken=accessToken,
    refreshToken=refreshToken,
    accessTokenExpiresIn=accessTokenExpiresIn,
    refreshTokenExpiresIn=refreshTokenExpiresIn,
    authority=authority
)

