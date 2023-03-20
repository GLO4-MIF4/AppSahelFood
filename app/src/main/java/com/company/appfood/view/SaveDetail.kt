//package com.company.appfood.view
//
//import android.annotation.SuppressLint
//import android.app.Activity
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.shape.ZeroCornerSize
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.filled.ArrowForward
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.navigation.NavController
//import com.company.appfood.R
//import com.company.appfood.component.PageIndicator
//import com.company.appfood.component.TopAppBarWithBack
//import com.company.appfood.di.DBHandler
//import com.company.appfood.navigation.Screen
//import com.company.appfood.ui.theme.*
//import com.company.appfood.view.manage.menu.MenuEditImagesSlider
//import com.company.appfood.view.manage.plat.UpdatePlat
//import com.company.appfood.view.manage.plat.ViewEditPlat
//import com.company.appfood.view.manage.plat.navControllerEditPlat
//
//
//@SuppressLint("StaticFieldLeak")
//lateinit var navControllerDetail: NavController
//
//
//@Composable
//fun DetailScreen(navController: NavController){
//    navControllerDetail = navController
////    DetailPlatDatabase()
//    ViewDetail()
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ViewDetail(){
////    my counter page
//    val pageCount by remember { mutableStateOf(0) }
//
//    Scaffold(
//        topBar = {
//            TopAppBarWithBack(onBackClick = {navControllerDetail.popBackStack()})
//        },
//        backgroundColor = bgwhitelight,
//        content = {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .verticalScroll(rememberScrollState())
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
//                        HeaderImagesSlider(pageCount)
//
//                    } //End of Box
//
//                    Surface(
//                        color = primary,
//                        shape = RoundedCornerShape(40.dp).copy(
//                            bottomStart = ZeroCornerSize,
//                            bottomEnd = ZeroCornerSize
//                        ), modifier = Modifier
//                            .fillMaxSize()
//                            .padding(top = 350.dp)
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
//                            //All of element items
//                            TitleAndSubtitleDetail()
//                            Spacer(modifier = Modifier.padding(10.dp))
//
//                            AddToCartPrice()
//                            Spacer(modifier = Modifier.padding(10.dp))
//
//                            Divider(color = primarywhite, thickness = 1.dp)
//                            Spacer(modifier = Modifier.padding(20.dp))
//
//                            About()
//                            Spacer(modifier = Modifier.padding(20.dp))
//
//                            AddToCartButton()
//
//                        } //End of Column
//                    } //End of Surface
//                }
//            }
//        } )
//
//}
//
//
//
////class DetailPlatDatabase : ComponentActivity() {
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContent {
////            AppFoodTheme {
////                Surface(
////                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
////                ) {
////                    //    my counter page
////                    val pageCount by remember { mutableStateOf(0) }
////
////                    Scaffold(
////                        topBar = {
////                            TopAppBarWithBack(onBackClick = {navControllerDetail.popBackStack()})
////                        },
////                        backgroundColor = bgwhitelight,
////                        content = {
////                            Box(
////                                modifier = Modifier
////                                    .fillMaxSize()
////                                    .verticalScroll(rememberScrollState())
////                            ) {
////                                ConstraintLayout {
////                                    val (imagesliderref, addtocartref) = createRefs()
////
////                                    Box(modifier = Modifier
////                                        .height(280.dp)
////                                        .constrainAs(imagesliderref) {
////                                            top.linkTo(imagesliderref.top)
////                                            bottom.linkTo(imagesliderref.top)
////                                            start.linkTo(parent.start)
////                                            end.linkTo(parent.end)
////                                        }) {
//////                        defined slider image
////                                        HeaderImagesSlider(pageCount)
////
////                                    } //End of Box
////
////                                    Surface(
////                                        color = primary,
////                                        shape = RoundedCornerShape(40.dp).copy(
////                                            bottomStart = ZeroCornerSize,
////                                            bottomEnd = ZeroCornerSize
////                                        ), modifier = Modifier
////                                            .fillMaxSize()
////                                            .padding(top = 350.dp)
////                                            .constrainAs(addtocartref) {
////                                                bottom.linkTo(parent.bottom)
////                                                start.linkTo(parent.start)
////                                                end.linkTo(parent.end)
////                                            }
////                                    ) {
////                                        Column(
////                                            modifier = Modifier
////                                                .fillMaxSize()
////                                                .padding(20.dp)
////                                        ) {
////                                            //All of element items
////                                            TitleAndSubtitleDetail(  LocalContext.current,
////                                                intent.getStringExtra("label"),
////                                                intent.getStringExtra("type_menu"),
////                                             )
////                                            Spacer(modifier = Modifier.padding(10.dp))
////
////                                            AddToCartPrice(LocalContext.current,
////                                                intent.getStringExtra("price"),
////                                              )
////                                            Spacer(modifier = Modifier.padding(10.dp))
////
////                                            Divider(color = primarywhite, thickness = 1.dp)
////                                            Spacer(modifier = Modifier.padding(20.dp))
////
////                                            About(  LocalContext.current,
////                                                intent.getStringExtra("description"))
////                                            Spacer(modifier = Modifier.padding(20.dp))
////
////                                            AddToCartButton()
////
////                                        } //End of Column
////                                    } //End of Surface
////                                }
////                            }
////                        } )
////
////                }
////            }
////        }
////    }
////}
////
//
//
//@Composable
//fun AddToCartButton() {
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Bottom
//    ) {
//        Button(
//            onClick = { navControllerDetail.navigate(Screen.CheckoutScreen.route) },
//            colors = ButtonDefaults.buttonColors(backgroundColor = white),
//            modifier = Modifier
//                .padding(8.dp)
//                .fillMaxWidth()
//                .height(60.dp),
//            shape = RoundedCornerShape(16.dp)
//        ) {
//            Text(text = "Ajouter au panier", color = secondary, fontWeight = FontWeight.Bold)
//            Icon(
//                imageVector = Icons.Default.ArrowForward,
//                contentDescription = null,
//                tint = primary,
//                modifier = Modifier
//                    .padding(start = 4.dp)
//                    .size(20.dp, 20.dp)
//            )
//        }
//
//    }
//}
//
//@Composable
//fun About(context: Context, cDescription: String?) {
//    val courseDescription = remember {
//        mutableStateOf(cDescription)
//    }
////    call instance of DataBase
//    val dbHandler: DBHandler = DBHandler(context)
//
//    Column(modifier = Modifier.fillMaxWidth())
//    {
//        Text(text = "A propos", style = MaterialTheme.typography.h6, color = white)
//        Spacer(modifier = Modifier.padding(5.dp))
//        Text(
//            text = courseDescription.value!!,
//            style = MaterialTheme.typography.caption, color = white
//        )
//    }
//}
//
//@Composable
//fun AddToCartPrice(
//    context: Context,
//    cPrice: String?,
//) {
//
//    val coursePrice= remember {
//        mutableStateOf(cPrice)
//    }
//
//
//
//
//    val counter = remember { mutableStateOf(1) }
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//        Text(text = coursePrice.value!!, color = white, fontSize = 24.sp, fontWeight = FontWeight.Bold)
//
//        Box(
//            modifier = Modifier
//                .width(110.dp)
//                .wrapContentHeight()
//                .clip(RoundedCornerShape(10.dp))
//                .background(primarywhite)
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_baseline_minimize_24),
//                        contentDescription = "",
//                        modifier = Modifier.padding(bottom = 15.dp),
//                        tint = white
//                    )
//                }
//
//                Text(
//                    text = "${counter.value}",
//                    color = white,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp
//                )
//
//                IconButton(onClick = { counter.value++ }) {
//                    Icon(imageVector = Icons.Default.Add, contentDescription = "", tint = white)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun TitleAndSubtitleDetail(
//    context: Context,
//    cName: String?,
//    cCategory: String?,
//
//    ) {
//    val activity = context as Activity
//    // on below line creating a variable for battery status
//    var courseName = remember {
//        mutableStateOf(cName)
//    }
//    val courseCategory= remember {
//        mutableStateOf(cCategory)
//    }
//
//    val dbHandler: DBHandler = DBHandler(context)
//
//    Text(text = courseName.value!!, style = MaterialTheme.typography.h6, color = white)
//    Text(
//        text = courseCategory.value!!,
//        style = MaterialTheme.typography.caption,
//        color = white
//    )
//}
//
//
//@Composable
//fun HeaderImagesSlider(pageCount: Int) {
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//            .padding(top = 10.dp)
//    ) {
//        Box(modifier = Modifier.fillMaxHeight()) {
//            Image(
//                painter = painterResource(id = R.drawable.sauce_gombo_couscous),
//                contentDescription = "",
//                modifier = Modifier
//                    .size(250.dp)
//                    .padding(top = 20.dp)
//            )
//        }
//        Spacer(modifier = Modifier.padding(10.dp))
//
//    }
//
//    val modifier = Modifier.fillMaxWidth().padding(top = 250.dp)
//    PageIndicator(pageCount,modifier)
//}
