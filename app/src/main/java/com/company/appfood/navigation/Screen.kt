package com.company.appfood.navigation

sealed class Screen (val route: String){

//   Screen for presentation
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
    object ListScreen : Screen("list_screen")
    object CheckoutScreen : Screen("checkout_screen")
//   Screen for administration
    object UsersScreen: Screen("users_screen")
    object ListUserScreen: Screen("list_user_screen")
    object EditUserScreen: Screen("edit_user_screen")
//    For Menus
    object HomeDashbordScreen : Screen("home_dash_screen")
    object ListMenuDashScreen : Screen("list_menu_dash_screen")
    object MenuDashScreen : Screen("add_menu_dash_screen")
    object EditMenuScreen : Screen("edit_menu_dash_screen")
//    For Dishes
    object ListPlatDashScreen : Screen("list_plat_dash_screen")
    object PlatDashScreen : Screen("add_plat_dash_screen")
    object EditPlatScreen : Screen("edit_plat_dash_screen")
//    For order
    object ListComandScreen : Screen("list_command_dash_screen")
    object ComandScreen : Screen("add_command_dash_screen")
    object EditComandScreen : Screen("edit_command_dash_screen")


}