package hu.ait.attendancetracker.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Messages : Screen("messages")
    object WritePost : Screen("writepost")
    object ViewPost : Screen("viewpost")
}
