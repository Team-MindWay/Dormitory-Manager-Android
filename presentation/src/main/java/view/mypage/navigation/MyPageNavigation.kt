package view.mypage.navigation

import androidx.navigation.NavController


const val MyPage_loute = "Mypage_loute"

fun NavController.navigationToMyPage() {
    this.navigate(MyPage_loute)
}
