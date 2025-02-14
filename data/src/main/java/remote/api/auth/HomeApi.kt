package remote.api.auth

import remote.dto.myrank.response.MyRankResponse
import remote.dto.rank.response.RankResponse
import retrofit2.http.GET

interface HomeApi {
    @GET("/rank")
    suspend fun getRank(): List<RankResponse>

    @GET("/my-rank")
    suspend fun getMyRank(): MyRankResponse

}