package repoistory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.admin.request.AdminCleanRequestModel
import model.admin.request.AdminPenaltyRequestModel
import model.admin.response.AdminPenaltyListResponseModel
import model.admin.response.AdminPenaltyResponseModel
import model.admin.response.AdminPointResponseModel
import model.admin.response.AdminUserListResponseModel
import model.admin.response.AdminUserResponseModel
import remote.datasource.admin.AdminDataSource
import remote.dto.admin.request.toDto
import remote.dto.admin.response.AdminPenaltyListResponse
import remote.dto.admin.response.AdminUserResponse
import remote.dto.admin.response.toModel
import reopoistory.AdminRepository
import javax.inject.Inject

class AdminRepositoryImpl @Inject constructor(
    private val adminDataSource: AdminDataSource
): AdminRepository
{
    override fun getUsers(): Flow<List<AdminUserListResponseModel>> =
        adminDataSource.getUsers().map { list -> list.map { it.toModel() } }

    override fun getUsersName(name: String?): Flow<List<AdminUserListResponseModel>> =
        adminDataSource.getUsersName(name = name).map { list -> list.map { it.toModel() } }

    override fun postPenalty(
        userId: String,
        body: AdminPenaltyRequestModel
    ): Flow<List<AdminPenaltyResponseModel>> =
        adminDataSource.postPenalty(userId = userId, body = body.toDto()).map { list -> list.map { it.toModel() } }

    override fun getPenaltyList(): Flow<AdminPenaltyListResponseModel> =
        adminDataSource.getPenaltyList().map { it.toModel() }

    override fun postClean(
        userId: String,
        body: AdminCleanRequestModel
    ): Flow<AdminUserResponseModel>  =
        adminDataSource.postClean(userId = userId, body = body.toDto()).map { it.toModel() }



}