package hu.ait.attendancetracker.ui.navigation

//sealed class MainNavigation(val route: String) {
//    object SplashScreen : MainNavigation("splash_screen")
//    object ShoppingListScreen : MainNavigation("shopping_list_screen")
//    object AddEditItemScreen : MainNavigation("add_edit_item_screen")
//
//}
//
//fun getRouteWithId(route: MainNavigation, id: Int): String {
//    return "${route.route}/$id"
//}

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Messages : Screen("messages")
    object WritePost : Screen("writepost")
}
