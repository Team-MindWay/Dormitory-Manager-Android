package remote.datasource.admin

import kotlinx.coroutines.flow.Flow
import remote.dto.admin.request.AdminCleanRequest
import remote.dto.admin.request.AdminPenaltyRequest
import remote.dto.admin.response.AdminPenaltyListResponse
import remote.dto.admin.response.AdminPenaltyResponse
import remote.dto.admin.response.AdminUserListResponse
import remote.dto.admin.response.AdminUserResponse
import remote.dto.myrank.response.MyRankResponse
import remote.dto.rank.response.RankResponse

interface AdminDataSource {
    fun getUsers(): Flow<List<AdminUserListResponse>>

    fun getUsersName(
        name: String?
    ): Flow<List<AdminUserListResponse>>

    fun postPenalty(
        userId: String,
        body: AdminPenaltyRequest
    ): Flow<List<AdminPenaltyResponse>>

    fun getPenaltyList(): Flow<AdminPenaltyListResponse>

    fun postClean(
        userId: String,
        body: AdminCleanRequest
    ): Flow<AdminUserResponse>
}