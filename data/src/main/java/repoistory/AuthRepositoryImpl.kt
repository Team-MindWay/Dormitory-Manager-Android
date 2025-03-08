package repoistory

import model.auth.request.GAuthLoginRequestBodyModel
import model.auth.response.GAuthLoginResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import local.datasource.LocalDataSource
import remote.datasource.GAuthDataSource
import remote.dto.auth.request.toDto
import remote.dto.auth.response.toLogin
import repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val gAuthDataSource: GAuthDataSource,
    private val localDataSource: LocalDataSource
) : AuthRepository {
    override fun gAuthLogout(): Flow<Unit> {
       return gAuthDataSource.gAuthLogout()
    }

    override fun getRole(): Flow<String> {
        return localDataSource.getAuthority()
    }

    override suspend fun gAuthAccess(refreshToken: String): Flow<GAuthLoginResponseModel> {
      return gAuthDataSource.gAuthAccess().map { it.toLogin()  }
    }

    override  fun gAuthLogin(body: GAuthLoginRequestBodyModel): Flow<GAuthLoginResponseModel> {
        return gAuthDataSource.gAuthLogin(body = body.toDto()).map { it.toLogin() }
    }

    override fun getRefreshToken(): Flow<String> {
      return localDataSource.getRefreshToken()
    }

    override suspend fun saveToken(data: GAuthLoginResponseModel) {
        localDataSource.setAccessToken(data.accessToken)
        localDataSource.setRefreshToken(data.refreshToken)
        localDataSource.setAccessTime(data.accessTokenExpiresIn)
        localDataSource.setRefreshTime(data.refreshTokenExpiresIn)
    }

    override suspend fun deleteToken() {
        localDataSource.deleteAccessToken()
        localDataSource.deleteRefreshToken()
        localDataSource.deleteAccessTime()
        localDataSource.deleteRefreshTime()
    }
}