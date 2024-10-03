package view.Mypage.component
import androidx.compose.runtime.Composable
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
fun MyDemritList(
    modifier: Modifier=Modifier

){
    Row (
        Modifier
            .width(320.dp)
            .height(155.dp)
            .background(color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp))
            .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,

    ){
        Column(
            Modifier
                .width(123.dp)
                .height(170.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,

        ){
            Column (
                Modifier
                    .width(123.dp)
                    .height(20.dp),
            ){
                Text(
                    text = "나의 벌점 내역",
                    style = TextStyle(
                        fontSize = 16.sp,

                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),

                        )
                )
            }
            Column(
                Modifier
                .width(160.dp)
                .height(160.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ){
                Text(
                    text = "라면 - 1회",
                    style = TextStyle(
                        fontSize = 15.sp,

                        fontWeight = FontWeight(500),
                        color = Color(0xFFD4D4D4),

                        )
                )
                Text(
                    text = "이불정리 - 2회",
                    style = TextStyle(
                        fontSize = 14.sp,

                        fontWeight = FontWeight(500),
                        color = Color(0xFFD4D4D4),

                        )

                )
                Text(
                    text = "타방 - 1회",
                    style = TextStyle(
                        fontSize = 14.sp,

                        fontWeight = FontWeight(500),
                        color = Color(0xFFD4D4D4),

                        )
                )
                Text(
                    text = "불, 에어컨 - 3회",
                    style = TextStyle(
                        fontSize = 14.sp,

                        fontWeight = FontWeight(500),
                        color = Color(0xFFD4D4D4),

                        )
                )
              


            }




        }

    }


}
@Composable
@Preview
fun PreviewMyDemritList(){
    MyDemritList()

}