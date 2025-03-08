package reopoistory

import kotlinx.coroutines.flow.Flow
import model.admin.request.AdminCleanRequestModel
import model.admin.request.AdminPenaltyRequestModel
import model.admin.request.AuthorityRequestModel
import model.admin.response.AdminPenaltyListResponseModel
import model.admin.response.AdminPenaltyResponseModel
import model.admin.response.AdminUserListResponseModel
import model.admin.response.AdminUserResponseModel

interface AdminRepository {
    fun getUsers(): Flow<List<AdminUserListResponseModel>>

    fun getStudentSearch(name: String): Flow<List<AdminUserListResponseModel>>

    fun changeAuthority(body: AuthorityRequestModel): Flow<Unit>

    fun postPenalty(userId: String, body: AdminPenaltyRequestModel): Flow<List<AdminPenaltyResponseModel>>

    fun getPenaltyList(): Flow<AdminPenaltyListResponseModel>

    fun postClean(userId: String, body: AdminCleanRequestModel): Flow<AdminUserResponseModel>


}