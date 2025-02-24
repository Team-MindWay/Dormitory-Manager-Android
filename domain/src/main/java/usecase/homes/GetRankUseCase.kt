package usecase.homes

import kotlinx.coroutines.flow.Flow
import model.rank.response.RankResponseModel
import reopoistory.HomesRepository
import javax.inject.Inject

class GetRankUseCase @Inject constructor(
    private val homesRepository: HomesRepository
) {
    operator fun invoke(): Flow<List<RankResponseModel>> =
        homesRepository.getRank()
}