package view.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import component.modifier.DoMaIcon
import view.theme.DoMaAndroidTheme

@Composable
fun PostDemeritComponent(
    modifier: Modifier = Modifier,
    onDemeritStudentClick: () -> Unit,

    ) {
    DoMaAndroidTheme { colors, typography ->
        Row(
            modifier = modifier
                .fillMaxSize()
                .height(72.dp)
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Text(
                text = "벌점 주기",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = typography.bodySmall.fontFamily,
                    fontWeight = FontWeight(500),
                    color = Color.White,
                    textAlign = TextAlign.Start,
                )
            )
            IconButton(
                onClick = { onDemeritStudentClick() },
                modifier = Modifier,
            ){
                DoMaIcon()
            }

        }

    }
}