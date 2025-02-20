package remote.dto.users.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import model.users.response.NoticeResponseModel

@JsonClass(generateAdapter = true)
data class NoticeResponse (
    @Json(name = "noticeId") val noticeId: Int,
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String,
    @Json(name = "name") val name: String,
)

fun NoticeResponse.toModel() = NoticeResponseModel(
    noticeId = noticeId,
    title = title,
    content = content,
    name = name,
)