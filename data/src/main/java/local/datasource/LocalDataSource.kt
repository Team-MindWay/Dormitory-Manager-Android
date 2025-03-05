package local.datasource

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getAccessToken(): Flow<String>

    suspend fun setAccessToken(accessToken: String)

    suspend fun deleteAccessToken()

    fun getAccessTime(): Flow<String>

    suspend fun setAccessTime(accessTime: String)

    suspend fun deleteAccessTime()

    fun getAuthority(): Flow<String>

    suspend fun setAuthority(authority: String)

    fun getRefreshToken(): Flow<String>

    suspend fun setRefreshToken(refreshToken: String)

    suspend fun deleteRefreshToken()

    fun getRefreshTime(): Flow<String>

    suspend fun setRefreshTime(refreshTime: String)

    suspend fun deleteRefreshTime()
}
