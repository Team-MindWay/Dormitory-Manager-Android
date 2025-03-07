package component.navigationbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kim.presentation.component.modifier.clickablesingle
import component.modifier.HomeIcon
import component.modifier.MyPageIcon
import component.modifier.NoticeIcon
import emumtype.DomaNavBarItemType
import view.theme.DoMaAndroidTheme

@Composable
fun DomaNavBar(
    modifier: Modifier = Modifier,
    currentDestination: DomaNavBarItemType,
    setCurrentDestination: (DomaNavBarItemType) -> Unit,
) {
    DoMaAndroidTheme { colors, _ ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .background(colors.WHITE)
        ) {
            DomaNavBarItemType.values().forEach { item ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .then(
                            if (currentDestination == item) {
                                Modifier
                            } else {
                                Modifier.clickablesingle(onClick = {setCurrentDestination(item)})
                            }
                        ),
                ) {
                    when (item) {
                        DomaNavBarItemType.Notice -> {
                            NoticeIcon(
                                isSelected = currentDestination == item,
                                modifier = modifier,
                            )
                        }

                        DomaNavBarItemType.HOME -> {
                            HomeIcon(
                                isSelected = currentDestination == item,
                                modifier = modifier,
                            )
                        }

                        DomaNavBarItemType.MY -> {
                            MyPageIcon(
                                isSelected = currentDestination == item,
                                modifier = modifier,
                            )
                        }
                    }
                }
            }
        }
    }
}