package com.company.appfood.view

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.DialogNavigator
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.company.appfood.navigation.Navigation

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
      BottomBar(navController = navController)
    }) {
        Navigation()
    }
}


@Composable
fun BottomBar(navController: NavController){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation() {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController as NavHostController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen:BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
  BottomNavigationItem(
      label = {
          Text(text = screen.title)
      },
      icon = {
          Icon(
              imageVector = screen.icon,
              contentDescription = "Navigation icon"
          )
      },
      selected = currentDestination?.hierarchy?.any {
          it.route == screen.route
      } == true,
      onClick = {
          navController.navigate(screen.route)
      }
  )
    
}