package usecase.admin

import kotlinx.coroutines.flow.Flow
import model.admin.response.AdminUserListResponseModel
import reopoistory.AdminRepository
import javax.inject.Inject

class GetUsersNameUseCase @Inject constructor(
    private val adminRepository: AdminRepository
) {
    operator fun invoke(name: String?): Flow<List<AdminUserListResponseModel>> =
        adminRepository.getUsersName(name = name)
}