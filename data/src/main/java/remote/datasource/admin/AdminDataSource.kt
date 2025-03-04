package remote.datasource.admin

import kotlinx.coroutines.flow.Flow
import model.admin.response.AdminStudentListResponseModel
import remote.dto.admin.request.AdminCleanRequest
import remote.dto.admin.request.AdminPenaltyRequest
import remote.dto.admin.request.AuthorityRequest
import remote.dto.admin.response.AdminPenaltyListResponse
import remote.dto.admin.response.AdminPenaltyResponse
import remote.dto.admin.response.AdminStudentLIstResponse
import remote.dto.admin.response.AdminUserListResponse
import remote.dto.admin.response.AdminUserResponse

interface AdminDataSource {
    fun getUsers(): Flow<List<AdminUserListResponse>>

    fun changeAuthority(body: AuthorityRequest): Flow<Unit>

    fun getStudentSearch(name: String): Flow<List<AdminUserListResponse>>

    fun postPenalty(userId: String, body: AdminPenaltyRequest): Flow<List<AdminPenaltyResponse>>

    fun getPenaltyList(): Flow<AdminPenaltyListResponse>

    fun postClean(userId: String, body: AdminCleanRequest): Flow<AdminUserResponse>
}