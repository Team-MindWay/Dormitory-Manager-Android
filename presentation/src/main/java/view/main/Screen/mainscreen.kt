package view.main.Screen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import view.main.component.MyRankingcomponent
import view.main.component.Rankingcomponent
import view.main.component.RankingcomponentltemData

import view.main.component.TimeComponent

@Composable
fun mainscreen (
    rankingcomponentltemData: List<RankingcomponentltemData>,


    modifier: Modifier=Modifier
){
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1E1E1E)),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,


    ){
        Row(
            Modifier
                .padding(0.dp)
                .width(360.dp)
                .height(54.dp),
            horizontalArrangement = Arrangement.spacedBy(102.59542846679688.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.Top,

        ){

        }

        Row(
            Modifier
                .width(360.dp)
                .height(60.dp)
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

        ){
            TimeComponent()
        }
        Column(
            Modifier
                .width(360.dp)
                .height(89.dp)
                .padding(start = 20.dp, top = 16.dp, end = 20.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,

        ){
            MyRankingcomponent()
        }
        Row (
            Modifier
                .width(360.dp)
                .height(521.dp)
                .padding(start = 20.dp, end = 20.dp) ,
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,

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
                        .height(50.dp)
                ){
                    Text(
                        text = "이번주 랭킹",
                        style = TextStyle(
                            fontSize = 18.sp,

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
                LazyColumn (
                    Modifier
                        .width(320.dp)
                        .height(434.dp)
                        .padding(start = 10.dp, end = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,

                    ) {
                    items(rankingcomponentltemData){
                        Rankingcomponent(
                            Rank=it.Rank,
                            name=it.name,
                            number=it.number


                        )
                    }


                }





                }

            }
        }

    }


@Composable
@Preview
fun PreviewMainScreen(){

    mainscreen(
        rankingcomponentltemData = listOf(
            RankingcomponentltemData(Rank = "5등", name = "김재관", number = "5회"),
            RankingcomponentltemData(Rank = "5등", name = "김재관", number = "5회"),
            RankingcomponentltemData(Rank = "5등", name = "김재관", number = "5회"),
            RankingcomponentltemData(Rank = "5등", name = "김재관", number = "5회"),



        )
    )
}