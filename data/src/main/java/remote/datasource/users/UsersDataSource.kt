package remote.datasource.users

import kotlinx.coroutines.flow.Flow
import remote.dto.users.response.UsersResponse

interface UsersDataSource {

    fun getUsers(): Flow<List<UsersResponse>>
}