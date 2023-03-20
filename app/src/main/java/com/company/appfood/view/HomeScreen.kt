package com.company.appfood.view

import android.annotation.SuppressLint

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.company.appfood.R
import com.company.appfood.component.PageIndicator
import com.company.appfood.navigation.Screen
import com.company.appfood.ui.theme.*


@SuppressLint("StaticFieldLeak")
lateinit var navControllerLocal: NavController

@Composable
fun HomeScreen(navController: NavController) {
    navControllerLocal = navController
    ViewHome()
}

@Preview(showBackground = true)
@Composable
fun ViewHome(){

    var pageCount by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ){
        ConstraintLayout {
            val (logoimageref, loginformref) = createRefs()
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(100.dp)
                    .constrainAs(logoimageref) {
                        top.linkTo(loginformref.top)
                        bottom.linkTo(loginformref.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                HeaderHome(navControllerLocal)
            } //End of first block

            Surface(
                color = ghost_white,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp)
                    .constrainAs(loginformref) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize()
                ){
                    // To slide item of menu
                    SlidingBannerView()
                    Spacer(modifier = Modifier.padding(10.dp))
                    val modifier = Modifier.fillMaxWidth()
                    PageIndicator(pageCount, modifier)

                    Spacer(modifier = Modifier.padding(10.dp))
                    CategoryView()

                    Spacer(modifier = Modifier.padding(10.dp))
                    PopularItemSection(navControllerLocal)

                }

            } //End of Surface

        } //End of ConstraintLayout
    }
}


@Composable
fun PopularItemSection(navControllerLocal: NavController) {
  Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text( text = "Consulter nos plats du jour", style = MaterialTheme.typography.h6)
        TextButton(
            onClick = { navControllerLocal.navigate(Screen.ListScreen.route) }) {
            Text(text = "voir plus", color = primary)
        }
    }

    Spacer(modifier = Modifier.padding(10.dp))
    PopularItems(navControllerLocal)
}

@Composable
fun PopularItems(navControllerLocal: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .background(white)
                .clickable { navControllerLocal.navigate(Screen.DetailScreen.route) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sauce_gombo),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.wrapContentHeight()) {
                        Text(
                            text = "Couscous Gombo",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )

                        Text(
                            text = "2 500 FCFA",
                            fontSize = 12.sp,
                            color = black
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(secondary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = "See detail",
                            modifier = Modifier.size(28.dp, 28.dp)
                        )
                    }

                } //End of Row

            }  //End of Column

        }  //End of Box

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .background(white)
                .clickable { navControllerLocal.navigate(Screen.DetailScreen.route) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ndole_camerounais),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(modifier = Modifier.wrapContentHeight()) {
                        Text(
                            text = "Ndole sahelienne",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )
                        Text(
                            text = "2500 FCFA",
                            fontSize = 12.sp,
                            color = secondary
                        )

                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(secondary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp), contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = "See detail",
                            modifier = Modifier.size(28.dp, 28.dp)
                        )
                    }

                }

            }
        } //End of Second Box

    } //End of Row
//   ===================================================
    Spacer(modifier = Modifier.height(10.dp))
//    ==================================================
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .background(white)
                .clickable { navControllerLocal.navigate(Screen.DetailScreen.route) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sauce_folere),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.wrapContentHeight()) {
                        Text(
                            text = "Couscous Folere",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )

                        Text(
                            text = "3.000 FCFA",
                            fontSize = 12.sp,
                            color = black
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(secondary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = "See detail",
                            modifier = Modifier.size(28.dp, 28.dp)
                        )
                    }

                } //End of Row

            }  //End of Column

        }  //End of Box

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .background(white)
                .clickable { navControllerLocal.navigate(Screen.DetailScreen.route) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ndole),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(modifier = Modifier.wrapContentHeight()) {
                        Text(
                            text = "Woullada",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )
                        Text(
                            text = "2500 FCFA",
                            fontSize = 12.sp,
                            color = secondary
                        )

                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(secondary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp), contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = "See detail",
                            modifier = Modifier.size(28.dp, 28.dp)
                        )
                    }

                }

            }
        } //End of Second Box

    }
}


@Composable
fun CategoryView() {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryButtonNew(
            icon = painterResource(id = R.drawable.ic_orange) ,
            backgroundColor = Color(0xffFFFFFF)
        )
        CategoryButtonNew(
            icon = painterResource(id = R.drawable.ic_veg),
            backgroundColor = Color(0xffFFFFFF)
        )
        CategoryButtonNew(
            icon = painterResource(id = R.drawable.ic_meat),
            backgroundColor = Color(0xffFFFFFF)
        )
        CategoryButtonNew(
            icon = painterResource(id = R.drawable.ic_cheese),
            backgroundColor = Color(0xffFFFFFF)
        )
    }
}

@Composable
fun CategoryButtonNew(icon: Painter, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(18.dp))
            .padding(18.dp)
    ) {
        Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun SlidingBannerView() {
    Image(
        painter = painterResource(id = R.drawable.ic_sale_banner),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth()
    )
}



@Composable
fun HeaderHome(navControllerLocal: NavController) {
    Image(
        painter = painterResource(id = R.drawable.login_bg),
        contentDescription = "Bg content",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Sahel App food",
            color = white,
            fontSize = 24.sp,
            letterSpacing = 2.sp,
            modifier = Modifier.padding(horizontal = 50.dp)
        )

        IconButton(
            onClick = {
            navControllerLocal.navigate(Screen.LoginScreen.route)
        }) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_person_pin_24),
                contentDescription = "Connection",
                modifier = Modifier.size(55.dp, 45.dp)
            )
        }

    }
}
