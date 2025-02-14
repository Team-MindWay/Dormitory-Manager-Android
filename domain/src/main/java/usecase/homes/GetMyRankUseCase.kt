package usecase.homes

import kotlinx.coroutines.flow.Flow
import model.myrank.response.MyRankResponseModel
import reopoistory.HomesRepository
import javax.inject.Inject

class GetMyRankUseCase @Inject constructor(
    private val homeRepository: HomesRepository
){
    operator fun invoke(): Flow<MyRankResponseModel> =
        homeRepository.getMyRank()

}