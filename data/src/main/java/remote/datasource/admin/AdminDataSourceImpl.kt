package remote.datasource.admin

import kotlinx.coroutines.flow.Flow
import remote.api.auth.AdminAPI
import remote.dto.admin.request.AdminCleanRequest
import remote.dto.admin.request.AdminPenaltyRequest
import remote.dto.admin.request.AuthorityRequest
import remote.dto.admin.response.AdminPenaltyListResponse
import remote.dto.admin.response.AdminPenaltyResponse
import remote.dto.admin.response.AdminUserListResponse
import remote.dto.admin.response.AdminUserResponse
import util.performApiRequest
import javax.inject.Inject

class AdminDataSourceImpl @Inject constructor(
    private val adminService: AdminAPI
): AdminDataSource
{
    override fun getStudentSearch(name: String): Flow<List<AdminUserListResponse>> =
        performApiRequest { adminService.getStudentSearch(name = name) }

    override fun changeAuthority(body: AuthorityRequest): Flow<Unit> =
        performApiRequest { adminService.changeAuthority(body = body) }

    override  fun getUsers(): Flow<List<AdminUserListResponse>> =
        performApiRequest { adminService.getUsers() }

    override fun postClean(userId: String, body: AdminCleanRequest): Flow<AdminUserResponse> =
        performApiRequest { adminService.postClean(userId = userId, body = body) }

    override fun postPenalty(userId: String, body: AdminPenaltyRequest): Flow<List<AdminPenaltyResponse>> =
        performApiRequest { adminService.postPenalty(userId = userId, body = body) }

    override fun getPenaltyList(): Flow<AdminPenaltyListResponse> =
        performApiRequest { adminService.getPenaltyList() }
}