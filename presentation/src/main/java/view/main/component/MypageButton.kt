package view.main.component
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kim.presentation.R

@Stable
@Composable
fun MypageButton(
    modifier: Modifier=Modifier,
    onClick: () -> Unit



){

    Box(
        Modifier
            .padding(1.dp)
            .width(24.dp)
            .height(24.dp)
            .clickable(onClick = onClick)
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
    MypageButton(){}
}