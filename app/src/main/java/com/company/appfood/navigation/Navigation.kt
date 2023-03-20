package com.company.appfood.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.company.appfood.view.*
import com.company.appfood.view.manage.command.ListComandScreen
import com.company.appfood.view.manage.home.HomeDashbordScreen
import com.company.appfood.view.manage.menu.EditMenuScreen
import com.company.appfood.view.manage.menu.ListMenuDashScreen
import com.company.appfood.view.manage.menu.MenuDashScreen
import com.company.appfood.view.manage.personnel.*
import com.company.appfood.view.manage.plat.EditPlatScreen
import com.company.appfood.view.manage.plat.ListPlatDashScreen
import com.company.appfood.view.manage.plat.PlatDashScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen.route
        ){

//      Presentation Navigation
        composable(route= Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.DetailScreen.route) {
            DetailScreen(navController = navController)
        }
        composable(Screen.ListScreen.route) {
            ListScreen(navController = navController)
        }
        composable(Screen.CheckoutScreen.route) {
            CheckoutScreen(navController = navController)
        }
//      Administration Navigation
        composable(route = Screen.UsersScreen.route) {
            UsersScreen(navController = navController)
        }
        composable(Screen.EditUserScreen.route) {
            EditUserScreen(navController = navController)
        }
        composable(Screen.ListUserScreen.route) {
            ListUserScreen(navController = navController)
        }

//      Dashboard Home
        composable(Screen.HomeDashbordScreen.route) {
            HomeDashbordScreen(navController = navController)
        }
        composable(Screen.ListMenuDashScreen.route) {
            ListMenuDashScreen(navController = navController)
        }
        composable(Screen.MenuDashScreen.route) {
            MenuDashScreen(navController = navController)
        }
        composable(Screen.EditMenuScreen.route) {
            EditMenuScreen(navController = navController)
        }
//        For Dishes
        composable(Screen.ListPlatDashScreen.route) {
            ListPlatDashScreen(navController = navController)
        }
        composable(Screen.PlatDashScreen.route) {
            PlatDashScreen(navController = navController)
        }
        composable(Screen.EditPlatScreen.route) {
            EditPlatScreen(navController = navController)
        }
//      For order
        composable(Screen.ListComandScreen.route) {
            ListComandScreen(navController = navController)
        }
//        composable(Screen.ComandScreen.route) {
//            ComandScreen(navController = navController)
//        }
//        composable(Screen.EditComandScreen.route) {
//            EditComandScreen(navController = navController)
//        }

    }
}
