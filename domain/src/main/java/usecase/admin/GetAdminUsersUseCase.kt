package usecase.admin

import kotlinx.coroutines.flow.Flow
import model.admin.response.AdminUserListResponseModel
import reopoistory.AdminRepository
import javax.inject.Inject

class GetAdminUsersUseCase @Inject constructor(
    private val adminRepository: AdminRepository
) {
    operator fun invoke(): Flow<List<AdminUserListResponseModel>> =
        adminRepository.getUsers()
}