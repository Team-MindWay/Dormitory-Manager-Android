package remote.datasource.users

import kotlinx.coroutines.flow.Flow
import remote.dto.users.response.UsersResponse
import java.util.UUID

interface UsersDataSource {
    fun getUsers(
        userId: UUID
    ): Flow<List<UsersResponse>>
}