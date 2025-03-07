package view.signin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kim.presentation.component.modifier.clickablesingle
import view.theme.DoMaAndroidTheme

@Stable
@Composable
fun DoMaLoginButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    DoMaAndroidTheme { colors, typography ->

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .clickablesingle(onClick = onClick)
                .background(color = colors.LOGIN, shape = RoundedCornerShape(size = 10.dp))
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp,
                ),

            ) {
            Text(
                text = "로그인",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = colors.WHITE,
                )
            )
        }
    }
}

@Preview
@Composable
fun DoMaLoginButtonPreview() {
    DoMaLoginButton {}
}