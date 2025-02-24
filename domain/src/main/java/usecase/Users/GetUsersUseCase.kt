package usecase.Users

import kotlinx.coroutines.flow.Flow
import model.users.response.UsersResponseModel
import reopoistory.UsersRepository
import java.util.UUID
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val usersRepository: UsersRepository
){
    suspend operator fun invoke(userId: UUID): Flow<UsersResponseModel> =
        usersRepository.getUsers(userId = userId)
}