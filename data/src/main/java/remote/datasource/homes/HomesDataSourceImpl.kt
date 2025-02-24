package remote.datasource.homes

import kotlinx.coroutines.flow.Flow
import remote.api.auth.HomeApi
import remote.dto.myrank.response.MyRankResponse
import remote.dto.rank.response.RankResponse
import util.performApiRequest
import javax.inject.Inject

class HomesDataSourceImpl@Inject constructor(
    private val homeService: HomeApi
): HomesDataSource {
    override fun getMyRank(): Flow<MyRankResponse> =
        performApiRequest { homeService.getMyRank() }


    override fun getRank(): Flow<List<RankResponse>> =
        performApiRequest { homeService.getRank() }


}