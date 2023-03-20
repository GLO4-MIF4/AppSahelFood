package com.company.appfood.view.manage.command

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.company.appfood.di.DBHandler
import com.company.appfood.domain.model.CommandModel
import com.company.appfood.domain.model.MenuModel
import com.company.appfood.navigation.Screen
import com.company.appfood.ui.theme.firaSansFamily
import com.company.appfood.ui.theme.ghost_white
import com.company.appfood.ui.theme.secondary
import com.company.appfood.view.manage.menu.*


@SuppressLint("StaticFieldLeak")
lateinit var navControllerCmd: NavController

@Composable
fun ListComandScreen(navController: NavController) {
    navControllerCmd = navController
    ViewInterfaceCmd()
}

@Composable
fun ViewInterfaceCmd() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ){
        ConstraintLayout {

            val (logoimageref, loginformref) = createRefs()
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(280.dp)
                    .constrainAs(logoimageref) {
                        top.linkTo(loginformref.top)
                        bottom.linkTo(loginformref.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                HeaderMenuDash()
            }

            Surface(
                color = ghost_white,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp)
                    .constrainAs(loginformref) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        secondary,
                                        fontFamily = firaSansFamily,
                                        fontWeight = FontWeight.Bold
                                    )
                                ){
                                    append("Informations sur les commandes")
                                }
                            },
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
//                    FloatingActionButton(
//                        onClick = {   },
//                        modifier = Modifier
//                            .height(52.dp)
//                            .widthIn(min = 52.dp)
//                            .padding(horizontal = 170.dp),
//                        backgroundColor = MaterialTheme.colors.primary
//
//                    ) {
//                        Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add new command")
//                    }
//                    Spacer(modifier = Modifier.padding(10.dp))
                    getComandFromDatabase(LocalContext.current)

                } //End of Column



            }  //End of bloc surface

        } //end of ConstraintLayout
    }
}


@Composable
fun getComandFromDatabase(context: Context) {
    lateinit var comandList: List<CommandModel>
    comandList = ArrayList<CommandModel>()

    val dbHandler: DBHandler = DBHandler(context);
    comandList = dbHandler.readCommand()!!

    Column(verticalArrangement = Arrangement.Center) {
        LazyColumn {
            itemsIndexed(comandList) { index, item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 12.dp),
                    elevation = 3.dp,
                    shape = RoundedCornerShape(corner = CornerSize(16.dp))
                ) {

                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(verticalArrangement = Arrangement.Center)
                        {
                            // on the below line we are creating a text.
                            Text(
                                text =  comandList[index].date_cmd,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black, textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = comandList[index].quantite,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black, textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            // on the below line we are creating a text.
                            Text(
                                text =  comandList[index].user_id,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black, textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text =  comandList[index].plat_id,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black, textAlign = TextAlign.Center
                            )
                        }
                        Row {

                            IconButton(
                                onClick = {
//                                    val i = Intent(context, UpdateMenu::class.java)
//                                    i.putExtra("date_cmd", comandList[index].date_cmd)
//                                    i.putExtra("quantite", comandList[index].quantite)
//                                    i.putExtra("user_id", comandList[index].user_id)
//                                    i.putExtra("plat_id", comandList[index].plat_id)
//                                    context.startActivity(i)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Edit,
                                    contentDescription = null,
                                    tint = Color.Green
                                )
                            }

                            IconButton(
                                onClick = {
//                                    comandList[index].id.let {
//                                        dbHandler.deleteCMD(
//                                            it
//                                        )
//                                    }
                                    Toast.makeText(context, "Suppréssion effectué avec succès", Toast.LENGTH_SHORT).show()
                                    navControllerDash.navigate(Screen.ListComandScreen.route)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Delete,
                                    contentDescription = null,
                                    tint = Color.Red
                                )
                            }
                        }
                    }

                }
            }
        }
    }



}
