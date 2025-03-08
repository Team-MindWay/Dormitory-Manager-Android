package model.auth.response

import emumtype.Authority

data class GAuthLoginResponseModel(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiresIn: String,
    val refreshTokenExpiresIn: String,
    val authority: Authority
)