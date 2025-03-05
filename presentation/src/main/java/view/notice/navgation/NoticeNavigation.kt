package view.main.navigation

import androidx.navigation.NavController

const val noticeRoute = "notice_route"

fun  NavController.navigationToNotice(){
    this.navigate(noticeRoute)
}
