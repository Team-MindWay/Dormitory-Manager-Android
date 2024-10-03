package view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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


@Composable
fun Rankingcomponent(
    modifier: Modifier=Modifier

){
    Column(
        Modifier
            .width(320.dp)
            .height(521.dp)
            .background(color = Color(0xFF252525), shape = RoundedCornerShape(size = 10.dp)),

        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,







    ){
        Column (
            Modifier
                .width(93.dp)
                .height(25.dp)
        ){
            Text(
                text = "이번주 랭킹",
                style = TextStyle(
                    fontSize = 20.sp,

                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),

                    )
            )
        }


        Row(
            Modifier
                .width(320.dp)
                .height(34.dp)
                .padding(start = 28.dp, top = 12.dp, end = 27.dp, bottom = 4.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,

        ){
            Text(
                text = "순위",
                style = TextStyle(
                    fontSize = 14.sp,

                    fontWeight = FontWeight(600),
                    color = Color(0xFF555555),

                    )
            )
            Spacer(modifier = Modifier.width(32.dp))

            Text(
                text = "이름",
                style = TextStyle(
                    fontSize = 14.sp,

                    fontWeight = FontWeight(600),
                    color = Color(0xFF555555),

                    )
            )
            Spacer(modifier = Modifier.width(150.dp))
            Text(
                text = "횟수",
                style = TextStyle(
                    fontSize = 14.sp,

                    fontWeight = FontWeight(600),
                    color = Color(0xFF555555),

                    )
            )

        }

    }






}
@Composable
@Preview
fun PreviewRankingcomponent(){

    Rankingcomponent()
}