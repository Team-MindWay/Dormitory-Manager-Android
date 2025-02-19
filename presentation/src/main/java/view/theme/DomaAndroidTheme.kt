package view.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import view.theme.color.ColorTheme
import view.theme.color.DoMaColor

@Composable
fun DoMaAndroidTheme(
    colors: ColorTheme = DoMaColor,
    typography: Typography = DoMaTypography,
    content: @Composable (colors: ColorTheme, typography: Typography) -> Unit

    ){
    content(colors = colors, typography = typography)

}