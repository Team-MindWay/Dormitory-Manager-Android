package view.Mypage.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import view.Mypage.component.DemritList
import view.Mypage.component.MyDemritList
import view.Mypage.component.Myclean

@Composable
fun Mypage(
    modifier: Modifier = Modifier
){

    Column(

        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF1E1E1E)) // 배경색 설정
    ){
        Row (
            Modifier
                .padding(0.dp)
                .width(360.dp)
                .height(80.dp),
            horizontalArrangement = Arrangement.spacedBy(102.59542846679688.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.Top,
        ){

        }
        Column (
            Modifier
                .width(360.dp)
                .height(522.dp),
             verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
             horizontalAlignment = Alignment.Start,
        ){
            Column (
                Modifier
                    .width(360.dp)
                    .height(80.dp)
                    .padding(start = 20.dp, end = 235.dp),
                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                ){
                Text(
                    text = "안녕하세요",
                    style = TextStyle(
                        fontSize = 20.sp,

                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),

                        )

                )
                Text(
                    text = AnnotatedString.Builder("이산님!").apply {
                        addStyle(
                            style = SpanStyle(
                                color = Color(0xFF9BFFA6),
                                fontSize = 27.sp  // 이산 부분의 글자 크기 설정
                            ),
                            start = 0,
                            end = 2
                        )
                    }.toAnnotatedString(),
                    style = TextStyle(
                        fontSize = 22.sp,  // 기본 글자 크기
                        fontWeight = FontWeight(900),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Start
                    )
                )



            }
            Column (
                Modifier
                    .width(360.dp)
                    .height(106.dp)
                    .padding(start = 20.dp, top = 16.dp, end = 20.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,


            ){
                Myclean()
            }
            Column (
                Modifier
                    .width(360.dp)
                    .height(171.dp)
                    .padding(start = 20.dp, end = 20.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,



            ){
                MyDemritList()
            }
            Column (
                Modifier
                    .width(360.dp)
                    .height(190.dp)
                    .padding(start = 20.dp, end = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ){
                DemritList()
            }


        }






    }
}

@Composable
@Preview
fun PreviewMypage(){
    Mypage()
}