package remote.datasource.homes

import kotlinx.coroutines.flow.Flow
import remote.dto.myrank.response.MyRankResponse
import remote.dto.rank.response.RankResponse

interface HomesDataSource {
    fun getRank(): Flow<List<RankResponse>>

    fun getMyRank(): Flow<MyRankResponse>
}