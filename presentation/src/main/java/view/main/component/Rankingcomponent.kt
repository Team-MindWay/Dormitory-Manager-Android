package view.main.component


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
data class RankingcomponentltemData(
    val Rank: String,
    val name: String,
    val number: String
)
@Composable
fun Rankingcomponent (
    Rank: String,
    name: String,
    number: String,
   modifier: Modifier=Modifier


){
    Row(
        Modifier
            .width(300.dp)
            .height(48.dp)
            .border(
                width = 1.dp,
                color = Color(0xFF4C4C4C),
                shape = RoundedCornerShape(size = 10.dp)
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(
            text = Rank,
            style = TextStyle(
                fontSize = 16.sp,

                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),

                )
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = name,
            style = TextStyle(
                fontSize = 16.sp,

                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),

                )
        )
        Spacer(modifier = Modifier.width(152.dp))
        Text(
            text = number,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),

                )
        )

    }


}
@Composable
@Preview
fun PreviewRankingcomponent(){
    Rankingcomponent(

        Rank = "5위",
        name = "김재관",
        number = "7회"

    )
}