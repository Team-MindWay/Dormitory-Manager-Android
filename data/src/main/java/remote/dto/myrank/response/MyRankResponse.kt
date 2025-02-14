package remote.dto.myrank.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.myrank.response.MyRankResponseModel
import java.util.UUID


@JsonClass(generateAdapter = true)
data class MyRankResponse (
    @Json(name = "userId") val userId: UUID,
    @Json(name = "rank") val rank: Int,
    @Json(name = "profileImage") val profileImage: String,
    @Json(name = "name") val name: String,
    @Json(name = "penaltyPoint") val penaltyPoint: Int,
)


fun MyRankResponse.toModel() = MyRankResponseModel(
    userId = userId,
    rank = rank,
    profileImage = profileImage,
    name = name,
    penaltyPoint = penaltyPoint
)

