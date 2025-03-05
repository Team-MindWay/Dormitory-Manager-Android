package usecase.admin

import kotlinx.coroutines.flow.Flow
import model.admin.response.AdminUserListResponseModel
import reopoistory.AdminRepository
import javax.inject.Inject

class GetStudentSearchUseCase @Inject constructor(
    private val adminRepository: AdminRepository
) {
    operator fun invoke(name: String): Flow<List<AdminUserListResponseModel>> =
        adminRepository.getStudentSearch(name = name)
}