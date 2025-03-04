package component.modifier

import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.kim.presentation.R
import view.theme.color.DoMaColor

@Composable
fun DoMaIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.left),
        contentDescription = "버튼",
        modifier = modifier
    )

}
@Composable
fun SerchIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
){
    Image(
        painter = painterResource(id = R.drawable.serach),
        contentDescription = "검색",
        modifier = modifier,
        colorFilter = if (tint != Color.Unspecified) ColorFilter.tint(tint) else null
    )
}
@Composable
fun HomeIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
){
    Icon(
        painter = painterResource(id = R.drawable.home),
        contentDescription = "homeIcon",
        modifier = modifier,
        tint = if (isSelected) DoMaColor.MAIN else DoMaColor.WHITE
    )
}
@Composable
fun MyPageIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
){
    Icon(
        painter = painterResource(id = R.drawable.mypage),
        contentDescription = "mypageIcon",
        modifier = modifier,
        tint = if (isSelected) DoMaColor.MAIN else DoMaColor.WHITE
    )
}
@Composable
fun NoticeIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
){
    Icon(
        painter = painterResource(id = R.drawable.notice),
        contentDescription = "mypageIcon",
        modifier = modifier,
        tint = if (isSelected) DoMaColor.MAIN else DoMaColor.WHITE
    )
}

@Composable
fun NotSearchIcon(
    modifier: Modifier = Modifier,
){
    Icon(
        painter = painterResource(id = R.drawable.notserach),
        contentDescription = "mypageIcon",
        modifier = modifier,
    )
}