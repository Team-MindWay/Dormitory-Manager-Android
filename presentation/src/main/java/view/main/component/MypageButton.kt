package view.main.component
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.R

@Composable
fun MypageButton(
    modifier: Modifier=Modifier,



){

    Box(
        Modifier
            .padding(1.dp)
            .width(24.dp)
            .height(24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "image description",
            contentScale = ContentScale.None,

            )
    }

}

@Composable
@Preview
fun PreviewMypageButton(){
    MypageButton()
}