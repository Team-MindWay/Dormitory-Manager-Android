package repository

import model.auth.request.GAuthLoginRequestBodyModel
import model.auth.response.GAuthLoginResponseModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
     fun gAuthLogin(body: GAuthLoginRequestBodyModel): Flow<GAuthLoginResponseModel>

     suspend fun gAuthAccess(refreshToken: String): Flow<GAuthLoginResponseModel>

     fun gAuthLogout(): Flow<Unit>

     fun getRefreshToken() : Flow<String>

     suspend fun saveToken(data: GAuthLoginResponseModel)

     fun getRole(): Flow<String>

     suspend fun deleteToken()
}