package remote.datasource.users

import kotlinx.coroutines.flow.Flow
import remote.api.auth.UsersAPi
import remote.dto.users.response.UsersResponse
import util.performApiRequest
import java.util.UUID
import javax.inject.Inject

class UsersDataSourceImpl @Inject constructor(
    private val usersService: UsersAPi
): UsersDataSource
{
    override fun getUsers(userId: UUID): Flow<List<UsersResponse>> =
        performApiRequest { usersService.getUsers(userId = userId) }
}