package com.company.appfood.view.manage.plat

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
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
import com.company.appfood.view.manage.menu.*

import java.time.Duration

@SuppressLint("StaticFieldLeak")
lateinit var navControllerAddPlat: NavController

@Composable
fun PlatDashScreen(navController: NavController) {
    navControllerAddPlat = navController
    ViewAddPlatInterface()
}

@Composable
fun ViewAddPlatInterface() {
    val pageCount by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBarWithBack(onBackClick = { navControllerAddPlat.popBackStack()})
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
                        PlatAddImagesSlider(pageCount)

                    } //End of Box

                    Surface(
                        color = bgwhitelight,
                        shape = RoundedCornerShape(40.dp).copy(
                            bottomStart = ZeroCornerSize,
                            bottomEnd = ZeroCornerSize
                        ), modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 70.dp)
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

                            ViewAddPlat(context = LocalContext.current)

                        } //End of Column
                    } //End of Surface
                }
            }
        } )

}


@Composable
fun ViewAddPlat( context: Context)
{
//    Recuperation des input entrees
    val activity = context as Activity
    // on below line creating a variable for battery status
    val courseName = remember {
        mutableStateOf(TextFieldValue())
    }
    val courseTypeMenu = remember {
        mutableStateOf(TextFieldValue())
    }
    val coursePrice = remember {
        mutableStateOf(TextFieldValue())
    }
    val courseDescription = remember {
        mutableStateOf(TextFieldValue())
    }
    val courseImage = remember {
        mutableStateOf(TextFieldValue())
    }
//    call instance of DataBase
    val dbHandler: DBHandler = DBHandler(context)
    Column(
        // on below line we are adding a modifier to it,
        modifier = Modifier
            .fillMaxSize()
            // on below line we are adding a padding.
            .padding(all = 5.dp),

    ) {

        Text(

            text = "Nom du plat",
            style  = TextStyle(
                textAlign = TextAlign.Left,
            ),
//            style = MaterialTheme.typography.subtitle1,
            color = dark_gray,
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
        )

        TextField(
            value = courseName.value,
            onValueChange = { courseName.value = it },
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
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Nom du plat") },
            shape = RoundedCornerShape(8.dp),

            ) //End of TextField Email
        Text(

            text = "Categorie du menu",
//            style = MaterialTheme.typography.subtitle1,
            style  = TextStyle(
                textAlign = TextAlign.Left,
            ),
            color = dark_gray,
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
        )
        TextField(
            value = courseTypeMenu.value,
            onValueChange = { courseTypeMenu.value = it },
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
            label = { Text(text = "Type de menu") },
            shape = RoundedCornerShape(8.dp),

            ) //End of TextField categorie
         Text(
            text = "Prix du menu",
            style  = TextStyle(
                textAlign = TextAlign.Left,

                ),
//            style = MaterialTheme.typography.subtitle1,
            color = dark_gray,
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
        )

        TextField(
            value = coursePrice.value,
            onValueChange = { coursePrice.value = it },
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
            label = { Text(text = "Prix") },
            shape = RoundedCornerShape(8.dp),

            ) //End of TextField categorie

        Text(

            text = "Description du menu",
            style  = TextStyle(
                textAlign = TextAlign.Left,

                ),
//            style = MaterialTheme.typography.subtitle1,
            color = dark_gray,
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
        )
        TextField(
            value = courseDescription.value,
            onValueChange = { courseDescription.value = it },
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
            label = { Text(text = "Description") },
            shape = RoundedCornerShape(8.dp),

            ) //End of TextField categorie
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = courseImage.value,
            onValueChange = { courseImage.value = it },
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
            label = { Text(text = "Image") },
            shape = RoundedCornerShape(8.dp),
        )

// End of TextField
        Button(
            onClick = {
                dbHandler.addNewPlat(
                    courseName.value.text,
                    courseTypeMenu.value.text,
                    coursePrice.value.text,
                    courseDescription.value.text,
                    courseImage.value.text
                )
                navControllerAddPlat.navigate(Screen.ListPlatDashScreen.route)
                Toast.makeText(context, "Ajout éffectue avec succès", Toast.LENGTH_SHORT).show()
            },

            colors = ButtonDefaults.buttonColors(backgroundColor = secondary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 34.dp),

            ) {
            Text(
                text = "Ajouter",
                color = white,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )

        } //End of login Button
    }

}


@Composable
fun PlatAddImagesSlider(pageCount: Int) {
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
                text = "Ajout d'un plat",
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



