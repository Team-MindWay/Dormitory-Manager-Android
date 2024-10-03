package view.Mypage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun Myclean(
    modifier: Modifier = Modifier,
) {
    Row(
        Modifier
            .width(320.dp)
            .height(74.dp)
            .background(color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp))
            .padding(start = 20.dp, top = 16.dp, end = 20.dp, bottom = 16.dp),  // 외부 패딩 추가
        horizontalArrangement = Arrangement.SpaceBetween,  // 요소 간 간격 조절
        verticalAlignment = Alignment.CenterVertically      // 수직 정렬 중앙 배치
    ) {
        // 첫 번째 정보 (오늘의 청소 구역)
        Column(
            Modifier
                .width(95.dp)

                .height(41.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "오늘의 청소 구역",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                )
            )
            Text(
                text = "3층 화장실",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                )
            )
        }

        // 두 번째 정보 (벌점)
        Column(
            Modifier
                .width(28.dp)
                .height(42.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "벌점",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                text = "14점",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center
                )
            )
        }

        // 세 번째 정보 (남은 청소)
        Column(
            Modifier
                .width(69.dp)
                .height(42.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "남은 청소",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                text = "2회",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}
@Composable
@Preview
fun PreviewMyvlean(){
    Myclean()
}