package reopoistory

import kotlinx.coroutines.flow.Flow
import model.myrank.response.MyRankResponseModel
import model.rank.response.RankResponseModel

interface HomesRepository {
    fun getRank(): Flow<List<RankResponseModel>>


    fun getMyRank(): Flow<MyRankResponseModel>
}