package reopoistory

import kotlinx.coroutines.flow.Flow
import model.users.response.UsersResponseModel
import java.util.UUID

interface UsersRepository {
  
  suspend fun getUsers(userId: UUID): Flow<List<UsersResponseModel>>
}