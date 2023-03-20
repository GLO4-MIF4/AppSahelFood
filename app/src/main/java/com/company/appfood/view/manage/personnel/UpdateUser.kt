package com.company.appfood.view.manage.personnel

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.company.appfood.component.PageIndicator
import com.company.appfood.component.TopAppBarWithBack
import com.company.appfood.di.DBHandler
import com.company.appfood.navigation.Screen
import com.company.appfood.ui.theme.*
import com.company.appfood.view.manage.menu.navControllerDash


@SuppressLint("StaticFieldLeak")
lateinit var navControllerEditUser: NavController

@Composable
fun EditUserScreen(navController: NavController) {
    navControllerEditUser = navController
    UpdateUser()
}

class UpdateUser : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFoodTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    val pageCount by remember { mutableStateOf(2) }

                    Scaffold(
                        topBar = {
                            TopAppBarWithBack(
                                onBackClick = {    navControllerEditUser.popBackStack() }
                            )
                        },
                        backgroundColor = primary,
                        content = {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                ConstraintLayout {
                                    val (imagesliderref, addtocartref) = createRefs()

                                    Box(modifier = Modifier
                                        .height(280.dp)
                                        .constrainAs(imagesliderref) {
                                            top.linkTo(imagesliderref.top)
                                            bottom.linkTo(imagesliderref.top)
                                            start.linkTo(parent.start)
                                            end.linkTo(parent.end)
                                        }) {
//                        defined slider image
                                        MenuEditImagesSlider(pageCount)

                                    } //End of Box

                                    Surface(
                                        color = bgwhitelight,
                                        shape = RoundedCornerShape(40.dp).copy(
                                            bottomStart = ZeroCornerSize,
                                            bottomEnd = ZeroCornerSize
                                        ), modifier = Modifier
                                            .fillMaxSize()
                                            .padding(top = 150.dp)
                                            .constrainAs(addtocartref) {
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


                                            ViewEditMenu(
                                                context = LocalContext.current,
                                                intent.getStringExtra("name"),
                                                intent.getStringExtra("email"),
                                                intent.getStringExtra("phone"),
                                                intent.getStringExtra("role")
                                            )

                                        } //End of Column
                                    } //End of Surface
                                }
                            }
                        }
                    )

                }
            }
        }
    }
}

@Composable
fun ViewEditMenu (context: Context,
                  cName: String?,
                  cEmail: String?,
                  cPhone: String?,
                  cRole: String?
) {


    val activity = context as Activity
    // on below line creating a variable for battery status
    var courseName = remember {
        mutableStateOf(cName)
    }
    val courseEmail= remember {
        mutableStateOf(cEmail)
    }
    val coursePhone= remember {
        mutableStateOf(cPhone)
    }
    val courseRole= remember {
        mutableStateOf(cRole)
    }
//    call instance of DataBase
    val dbHandler: DBHandler = DBHandler(context)
//    Form begin

    Column(
        // on below line we are adding a modifier to it,
        modifier = Modifier
            .fillMaxSize()
            // on below line we are adding a padding.
            .padding(all = 5.dp),

//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
    ) {
        Text(

            text = "Noms ",
            style  = TextStyle(
                textAlign = TextAlign.Left,
            ),
//            style = MaterialTheme.typography.subtitle1,
            color = dark_gray,
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
        )

        TextField(
            value = courseName.value!!,
            onValueChange = { courseName.value = it },
            leadingIcon = {
                Row(
                    modifier = Modifier.wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = primary
                        )
                        Canvas(
                            modifier = Modifier
                                .height(24.dp)
                                .padding(start = 10.dp)
                        ) {
                            drawLine(
                                color = light_gray,
                                start = Offset(0f, 0f),
                                end = Offset(0f, size.height),
                                strokeWidth = 2.0F
                            )
                        }
                    }
                )
            },
            placeholder = { Text(text = "Entrer vos noms") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = white,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Noms") },
            shape = RoundedCornerShape(8.dp),

            ) //End of TextField Email
        Text(

            text = "Email",
//            style = MaterialTheme.typography.subtitle1,
            style  = TextStyle(
                textAlign = TextAlign.Left,
            ),
            color = dark_gray,
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
        )
        TextField(
            value = courseEmail.value!!,
            onValueChange = { courseEmail.value = it },
            leadingIcon = {
                Row(
                    modifier = Modifier.wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null,
                            tint = primary
                        )
                        Canvas(
                            modifier = Modifier
                                .height(24.dp)
                                .padding(start = 10.dp)
                        ) {
                            drawLine(
                                color = light_gray,
                                start = Offset(0f, 0f),
                                end = Offset(0f, size.height),
                                strokeWidth = 2.0F
                            )
                        }
                    }
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = white,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Votre mail") },
            shape = RoundedCornerShape(8.dp),

            ) //End of TextField categorie
        Text(

            text = "Telephone",
            style  = TextStyle(
                textAlign = TextAlign.Left,

                ),
//            style = MaterialTheme.typography.subtitle1,
            color = dark_gray,
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
        )
        TextField(
            value = coursePhone.value!!,
            onValueChange = { coursePhone.value = it },
            leadingIcon = {
                Row(
                    modifier = Modifier.wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = null,
                            tint = primary
                        )
                        Canvas(
                            modifier = Modifier
                                .height(24.dp)
                                .padding(start = 10.dp)
                        ) {
                            drawLine(
                                color = light_gray,
                                start = Offset(0f, 0f),
                                end = Offset(0f, size.height),
                                strokeWidth = 2.0F
                            )
                        }
                    }
                )
            },

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = white,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Votre Telephone") },
            shape = RoundedCornerShape(8.dp),

            ) //End of TextField categorie
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = courseRole.value!!,
            onValueChange = { courseRole.value = it },
            leadingIcon = {
                Row(
                    modifier = Modifier.wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = primary
                        )
                        Canvas(
                            modifier = Modifier
                                .height(24.dp)
                                .padding(start = 10.dp)
                        ) {
                            drawLine(
                                color = light_gray,
                                start = Offset(0f, 0f),
                                end = Offset(0f, size.height),
                                strokeWidth = 2.0F
                            )
                        }
                    }
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = white,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Role du personnel") },
            shape = RoundedCornerShape(8.dp),
        )

// End of TextField
        Button(
            onClick = {
                dbHandler.updateUser(
                    cName!!,
                    courseName.value,
                    courseEmail.value,
                    coursePhone.value,
                    courseRole.value
                )
                navControllerEditUser.navigate(Screen.ListUserScreen.route)
                Toast.makeText(context, "Mise a jour éffectue avec succès", Toast.LENGTH_SHORT).show()
            },

            colors = ButtonDefaults.buttonColors(backgroundColor = secondary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 34.dp),

            ) {
            Text(
                text = "Modifier",
                color = white,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )

        } //End of login Button
    }

}




@Composable
fun MenuEditImagesSlider(pageCount: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 10.dp)
    ) {
        Box(modifier = Modifier.fillMaxHeight(),
        ) {
            Text(
                text = "Edition d'un personnel",
                color = white,
                fontSize = 35.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 2.sp
            )

        }
        Spacer(modifier = Modifier.padding(10.dp))

    }

    val modifier = Modifier.fillMaxWidth().padding(top = 250.dp)
    PageIndicator(pageCount,modifier)
}
