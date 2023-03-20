package com.company.appfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.company.appfood.navigation.Navigation
import com.company.appfood.ui.theme.AppFoodTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFoodTheme {
                // A surface container using the 'background' color from the theme
//                InitApplicationContent()
                Navigation()

            }
        }
    }
}



//@Composable
//fun  InitApplicationContent() {
//    Surface(color = MaterialTheme.colors.background) {
//        Navigation()
//    }
//}

