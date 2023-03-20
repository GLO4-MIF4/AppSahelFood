package com.company.appfood.view.manage.personnel


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.company.appfood.R
import com.company.appfood.di.DBHandler

import com.company.appfood.domain.model.MyUserModel
import com.company.appfood.navigation.Screen
import com.company.appfood.ui.theme.*
import com.company.appfood.view.*


@SuppressLint("StaticFieldLeak")
lateinit var navControllerUser: NavController

@Composable
fun ListUserScreen(navController: NavController) {
    navControllerUser = navController
    ViewInterfaceUser()
}


@Preview(showBackground = true)
@Composable
fun ViewInterfaceUser()
{
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
                HeaderUser()
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
                                    append("Informations sur le personnel")
                                }
                            },
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    FloatingActionButton(
                        onClick = {  navControllerUser.navigate(Screen.UsersScreen.route) },
                        modifier = Modifier
                            .height(52.dp)
                            .widthIn(min = 52.dp)
                            .padding(horizontal = 170.dp),
                        backgroundColor = MaterialTheme.colors.primary

                    ) {
                        Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add new user")
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    getAllUsers(LocalContext.current)

                } //End of Column



            }  //End of bloc surface

        } //end of ConstraintLayout
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun getAllUsers(context: Context) {
    lateinit var userList: List<MyUserModel>
    userList = ArrayList<MyUserModel>()

    val dbHandler: DBHandler = DBHandler(context);
    userList = dbHandler.readUsers()!!


    Column(verticalArrangement = Arrangement.Center) {
        LazyColumn {
            itemsIndexed(userList) { index, item ->
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
                                text =  userList[index].name,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black, textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = userList[index].email,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black, textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            // on the below line we are creating a text.
                            Text(
                                text =  userList[index].phone,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black, textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text =  userList[index].role,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black, textAlign = TextAlign.Center
                            )
                        }
                        Row {

                            IconButton(
                                onClick = {
                                    val i = Intent(context, UpdateUser::class.java)
                                    i.putExtra("name", userList[index].name)
                                    i.putExtra("email", userList[index].email)
                                    i.putExtra("phone", userList[index].phone)
                                    i.putExtra("role", userList[index].role)
                                    context.startActivity(i)
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
                                    userList[index].id.let {
                                        dbHandler.deleteUser(
                                            it
                                        )
                                    }
                                    Toast.makeText(context, "Suppréssion effectué avec succès", Toast.LENGTH_SHORT).show()
                                    navControllerUser.navigate(Screen.UsersScreen.route)
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

@Composable
fun HeaderUser() {
    Image(
        painter = painterResource(id = R.drawable.login_bg),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navControllerUser.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                tint = white,
                modifier = Modifier.size(32.dp, 32.dp)
            )

        }

        Text(
            text = "Adminstration Personnel",
            color = white,
            modifier = Modifier.padding(end = 150.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

    } //End Row
}

