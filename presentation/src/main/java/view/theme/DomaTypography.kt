package view.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kim.presentation.R

val suit = FontFamily(
    Font(R.font.suitregular),
    Font(R.font.suitbold),
)


val DoMaTypography = Typography(
    headlineLarge = TextStyle(
        fontSize = 32.sp,
        fontFamily = suit,
        lineHeight = 38.4.sp
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontFamily = suit,
        lineHeight = 33.6.sp
    ),
    headlineSmall = TextStyle(
        fontSize = 24.sp,
        fontFamily = suit,
        lineHeight = 31.2.sp
    ),
    bodyLarge = TextStyle(
        fontSize = 20.sp,
        fontFamily = suit,
        lineHeight = 30.sp
    ),
    bodyMedium = TextStyle(
        fontSize = 18.sp,
        fontFamily = suit,
        lineHeight = 27.sp
    ),
    bodySmall = TextStyle(
        fontSize = 16.sp,
        fontFamily = suit,
        lineHeight = 24.sp
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontFamily = suit,
        lineHeight = 21.sp
    )
)