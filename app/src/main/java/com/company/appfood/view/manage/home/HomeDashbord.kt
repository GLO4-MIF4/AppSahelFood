package com.company.appfood.view.manage.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
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
import com.company.appfood.view.*


@SuppressLint("StaticFieldLeak")
lateinit var navControllerDash: NavController

@Composable
fun HomeDashbordScreen(navController: NavController) {
    navControllerDash = navController
    ViewHomeDashbord()
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun ViewHomeDashbord() {
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
                HeaderDash()
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
                        .fillMaxWidth()
                ){
                    // To slide item of menu
                    SlidingBannerDashView()
                    Spacer(modifier = Modifier.padding(10.dp))
                    val modifier = Modifier.fillMaxWidth()
                    PageIndicator(pageCount, modifier)

                    Spacer(modifier = Modifier.padding(10.dp))
                    DashItemSection(navControllerDash)
                }

            }

        } //End of Surface

    }    //End of ConstraintLayout
}

@Composable
fun HeaderDash() {
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

    }
}

@Composable
fun SlidingBannerDashView() {
    Image(
        painter = painterResource(id = R.drawable.ic_sale_banner_admin),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun DashItemSection(navControllerDash: NavController) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text( text = "Bienvenue dans l'espace administration", style = MaterialTheme.typography.h6)
//        TextButton(
//            onClick = { navControllerDash.navigate(Screen.ListScreen.route) }) {
//            Text(text = "voir plus", color = primary)
//        }
    }

    Spacer(modifier = Modifier.padding(10.dp))
    DashItems(navControllerDash)
}

@Composable
fun DashItems(navControllerLocal: NavController) {
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
                .clickable { navControllerLocal.navigate(Screen.ListUserScreen.route) }
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
                        painter = painterResource(id = R.drawable.gest_user),
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
                            text = "Gerer Personnel",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = secondary
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
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "",
                            tint = white,
                            modifier = Modifier.size(32.dp, 32.dp)
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
                .clickable { navControllerLocal.navigate(Screen.ListMenuDashScreen.route) }
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
                        painter = painterResource(id = R.drawable.menu_best),
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
                            text = "Gerer menus",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
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
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "",
                            tint = white,
                            modifier = Modifier.size(32.dp, 32.dp)
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
                .clickable { navControllerLocal.navigate(Screen.ListPlatDashScreen.route) }
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
                        painter = painterResource(id = R.drawable.menu_food),
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
                            text = "Gerer plats",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = secondary
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
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "",
                            tint = white,
                            modifier = Modifier.size(32.dp, 32.dp)
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
                .clickable { navControllerLocal.navigate(Screen.ListComandScreen.route) }
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
                        painter = painterResource(id = R.drawable.all_food),
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
                            text = "Gerer commandes",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
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
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "",
                            tint = white,
                            modifier = Modifier.size(32.dp, 32.dp)
                        )
                    }

                }

            }
        } //End of Second Box

    }
}




