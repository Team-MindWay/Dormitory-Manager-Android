package repoistory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.myrank.response.MyRankResponseModel
import model.rank.response.RankResponseModel
import remote.datasource.homes.HomesDataSource
import remote.dto.myrank.response.toModel
import remote.dto.rank.response.toModel
import reopoistory.HomesRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomesDataSource
): HomesRepository{
    override fun getMyRank(): Flow<MyRankResponseModel> {
        return  homeDataSource.getMyRank().map { it.toModel() }
    }

    override fun getRank(): Flow<List<RankResponseModel>> {
        return homeDataSource.getRank().map {list -> list.map { it.toModel() }  }
    }

}