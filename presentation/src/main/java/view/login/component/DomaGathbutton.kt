package view.login.component

import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
 fun DomaGathbutton (
     modifier: Modifier=Modifier,
     onClick: () -> Unit

 ){
    Row(
        modifier = Modifier
            .width(320.dp)
            .height(52.dp)
            .background(color = Color(0xFF494949), shape = RoundedCornerShape(size = 10.dp))
            .padding(start = 133.dp, top = 13.dp, end = 133.dp, bottom = 13.dp)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    )


        {
            Text(

                text = "Ganth",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFE0E0E0),

                    )
            )


        }


}
@Preview
@Composable
fun DomaGauthbuttonPrevies(){
    DomaGathbutton {

    }
}