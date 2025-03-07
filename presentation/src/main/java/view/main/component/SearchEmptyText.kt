package view.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import view.theme.DoMaAndroidTheme

@Composable
internal fun SearchEmptyText() {

    DoMaAndroidTheme {
            colors, typography ->
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text ="없는 이름이에요!",
                style = typography.bodySmall,
                fontWeight = FontWeight.SemiBold,
                color = colors.CardShadow
            )
        }
    }
}