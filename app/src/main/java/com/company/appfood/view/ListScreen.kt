package com.company.appfood.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.company.appfood.R
import com.company.appfood.di.DBHandler
import com.company.appfood.domain.model.PlatModel
import com.company.appfood.navigation.Screen
import com.company.appfood.ui.theme.*
import com.company.appfood.view.manage.plat.UpdatePlat

@SuppressLint("StaticFieldLeak")
lateinit var navControllerList: NavController

@Composable
fun ListScreen(navController: NavController) {
    navControllerList = navController
    ViewList()
}

@Preview(showBackground = true)
@Composable
fun ViewList() {
    Box(
        modifier = Modifier
            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
    ){
        ConstraintLayout {
            val (topappbarbgref, popularitemsref) = createRefs()

            Box(modifier = Modifier
                .height(100.dp)
                .constrainAs(topappbarbgref) {
                    top.linkTo(topappbarbgref.top)
                    bottom.linkTo(topappbarbgref.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {

                HeaderHomeListItems()
            }

            Surface(
                color = ghost_white,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ), modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp)
                    .constrainAs(popularitemsref) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {

                    ListItemSection()
                    Spacer(modifier = Modifier.padding(10.dp))

                    ListItemSectionDataBase(LocalContext.current)

                }

            } //End Surface

        } //End of ConstraintLayout
    } //End Box
}

@Composable
fun ListItemSectionDataBase(context: Context) {

    lateinit var courseList: List<PlatModel>
    courseList = ArrayList<PlatModel>()

    val dbHandler: DBHandler = DBHandler(context);
    courseList = dbHandler.readPlats()!!
    Row(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(white)
                .clickable {
                    navControllerList.navigate(Screen.DetailScreen.route)
                }
        ) {

            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    ) {


                    itemsIndexed(courseList) { index, item ->
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
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.wrapContentHeight()) {
                            Text(
                                text =  courseList[index].label,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = black
                            )
                            Text( text =  courseList[index].prix, fontSize = 12.sp, color = primary)
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(secondary)
                                .padding(4.dp)
                                .shadow(elevation = 8.dp)
                                .clickable {
//                                    val i = Intent(context, DetailPlatDatabase::class.java)
//                                    i.putExtra("label", courseList[index].label)
//                                    i.putExtra("type_menu", courseList[index].type_menu)
//                                    i.putExtra("prix", courseList[index].prix)
//                                    i.putExtra("description", courseList[index].descrition)
//                                    i.putExtra("image", courseList[index].image)
//
//                                    context.startActivity(i)
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                                contentDescription = "See detail",
                                modifier = Modifier.size(28.dp, 28.dp)
                            )
                        }
                    }
                    }
                        //End of itemsIndexes
                } //End lazyColumn
            }

        }

}


@Composable
fun ListItemSection() {
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
                .clip(RoundedCornerShape(16.dp))
                .background(white)
                .clickable {
                    navControllerList.navigate(Screen.DetailScreen.route)
                }
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
//                delimiter spacing
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.wrapContentHeight()) {
                        Text(
                            text = "Ndole sahelienne",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )
                        Text(text = "2500 CFA", fontSize = 12.sp, color = primary)
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(secondary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = "See detail",
                            modifier = Modifier.size(28.dp, 28.dp)
                        )
                    }
                } //End of Row
            } //End of Column
        } //End Box
        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(white)
                .clickable { navControllerList.navigate(Screen.DetailScreen.route) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

                    Image(
                        painter = painterResource(id = R.drawable.sauce_folere),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(modifier = Modifier.wrapContentHeight()) {
                        Text(
                            text = "Couscous Folere",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )
                        Text(text = "1 500 CFA", fontSize = 12.sp, color = primary)
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(secondary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = "See detail",
                            modifier = Modifier.size(28.dp, 28.dp)
                        )
                    }
                }  //End Row

            } //End Column
        } //End Box

    }
}

@Composable
fun HeaderHomeListItems() {
    Image(
        painter = painterResource(id = R.drawable.login_bg),
        contentDescription = "login_bg",
        contentScale = ContentScale.FillWidth, modifier = Modifier.fillMaxSize()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navControllerList.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                tint = white
            )
        }

        Text(
            text = "Liste des plats du jour, passer vos commandes",
            color = white,
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )

    } //End Row
}
