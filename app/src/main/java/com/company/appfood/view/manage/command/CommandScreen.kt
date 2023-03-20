//package com.company.appfood.view.manage.command
//
//import android.annotation.SuppressLint
//import android.app.Activity
//import android.content.Context
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.shape.ZeroCornerSize
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.dp
//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.navigation.NavController
//import com.company.appfood.component.TopAppBarWithBack
//import com.company.appfood.di.DBHandler
//import com.company.appfood.ui.theme.bgwhitelight
//import com.company.appfood.ui.theme.primary
//import com.company.appfood.view.manage.menu.MenuAddImagesSlider
//import com.company.appfood.view.manage.menu.ViewAddMenu
//import com.company.appfood.view.manage.menu.navControllerAddMenu
//
//
//@SuppressLint("StaticFieldLeak")
//lateinit var navControllerAddCmd: NavController
//
//@Composable
//fun MenuDashScreen(navController: NavController) {
//    navControllerAddCmd = navController
////    ViewInterfaceAddMenu()
//    ViewAddCmdInterface()
//}
//
//@Composable
//fun ViewAddCmdInterface() {
//    val pageCount by remember { mutableStateOf(1) }
//
//    Scaffold(
//        topBar = {
//            TopAppBarWithBack(onBackClick = { navControllerAddCmd.popBackStack()})
//        },
//        backgroundColor = primary,
//        content = {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//            ) {
//                ConstraintLayout {
//                    val (imagesliderref, addtocartref) = createRefs()
//
//                    Box(modifier = Modifier
//                        .height(280.dp)
//                        .constrainAs(imagesliderref) {
//                            top.linkTo(imagesliderref.top)
//                            bottom.linkTo(imagesliderref.top)
//                            start.linkTo(parent.start)
//                            end.linkTo(parent.end)
//                        }) {
////                        defined slider image
//                        MenuAddImagesSlider(pageCount)
//
//                    } //End of Box
//
//                    Surface(
//                        color = bgwhitelight,
//                        shape = RoundedCornerShape(40.dp).copy(
//                            bottomStart = ZeroCornerSize,
//                            bottomEnd = ZeroCornerSize
//                        ), modifier = Modifier
//                            .fillMaxSize()
//                            .padding(top = 150.dp)
//                            .constrainAs(addtocartref) {
//                                bottom.linkTo(parent.bottom)
//                                start.linkTo(parent.start)
//                                end.linkTo(parent.end)
//                            }
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .padding(20.dp)
//                        ) {
//
//                            ViewAddCmd(context = LocalContext.current)
//
//                        } //End of Column
//                    } //End of Surface
//                }
//            }
//        } )
//}
//
//@Composable
//fun ViewAddCmd(context: Context) {
//    //    Recuperation des input entrees
//    val activity = context as Activity
//    // on below line creating a variable for battery status
//    val date_cmd = remember {
//        mutableStateOf(TextFieldValue())
//    }
//    val quantite = remember {
//        mutableStateOf(TextFieldValue())
//    }
//    val courseDescription = remember {
//        mutableStateOf(TextFieldValue())
//    }
//    val courseImage = remember {
//        mutableStateOf(TextFieldValue())
//    }
////    call instance of DataBase
//    val dbHandler: DBHandler = DBHandler(context)
//
//}
