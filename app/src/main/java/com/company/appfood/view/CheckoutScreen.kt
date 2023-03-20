package com.company.appfood.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.company.appfood.R
import com.company.appfood.di.DBHandler
import com.company.appfood.navigation.Screen
import com.company.appfood.ui.theme.*
import com.company.appfood.view.manage.menu.navControllerAddMenu


@SuppressLint("StaticFieldLeak")
lateinit var navControllerCK: NavController

@Composable
fun CheckoutScreen(navController: NavController) {
    navControllerCK = navController
    ViewCheckout()
}


@Preview(showBackground = true)
@Composable
fun ViewCheckout() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout {
            val (cartitemsref, checkoutref) = createRefs()

            Box(modifier = Modifier
                .height(100.dp)
                .constrainAs(cartitemsref) {
                    top.linkTo(cartitemsref.top)
                    bottom.linkTo(cartitemsref.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                HeaderCartItems()
            } //End Box

            Surface(
                color = ghost_white,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomEnd = ZeroCornerSize,
                    bottomStart = ZeroCornerSize
                ), modifier = Modifier
                    .padding(top = 70.dp)
                    .constrainAs(checkoutref) {
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
                    ItemsCart()
                    Spacer(modifier = Modifier.padding(10.dp))
//                    ItemsCart()
//                    Spacer(modifier = Modifier.padding(20.dp))
                    CheckoutDetails()
                    Spacer(modifier = Modifier.padding(20.dp))
                    ApplyCoupon(context = LocalContext.current)
                    Spacer(modifier = Modifier.padding(10.dp))

                } // End Column

            } //End Surface
        } //End ConstraintLayout
    }
}

@Composable
fun CheckoutDetails() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(16.dp))
            .background(white)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Text(text = "Details commande", fontSize = 16.sp, fontWeight = FontWeight.Bold)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Couscous sauce Combo", fontSize = 14.sp, color = Color.Gray)

                Text(text = "1 x 2500.00 CFA", fontSize = 14.sp, color = Color.Gray)
            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 10.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//
//                Text(text = "Poisson", fontSize = 14.sp, color = Color.Gray)
//
//                Text(text = "1 x 1500.00 CFA", fontSize = 14.sp, color = Color.Gray)
//            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Terme de la commande", fontSize = 14.sp, color = Color.Gray)

                Text(text = "Numeraire", fontSize = 14.sp, color = Color.Gray)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Coupon ", fontSize = 14.sp, color = Color.Gray)

                Text(text = "500.00 CFA", fontSize = 14.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Divider(color = Color.Gray, thickness = 1.dp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Total a Payer",
                    fontSize = 14.sp,
                    color = black,
                    fontWeight = FontWeight.Bold
                )

                Text(text = "3500 CFA", fontSize = 14.sp, color = primary)
            }

            Spacer(modifier = Modifier.padding(10.dp))

//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Bottom
//            ) {
//
//                Button(
//                    onClick = { /*TODO*/ },
//                    colors = ButtonDefaults.buttonColors(backgroundColor = secondary),
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .fillMaxWidth()
//                        .height(60.dp),
//                    shape = RoundedCornerShape(16.dp)
//                ) {
//                    Text(text = "Payer", color = white, fontWeight = FontWeight.Bold)
//
//                    Icon(
//                        imageVector = Icons.Default.ArrowForward,
//                        contentDescription = "",
//                        tint = white,
//                        modifier = Modifier
//                            .padding(start = 4.dp)
//                            .size(20.dp, 20.dp)
//                    )
//
//                }
//            }

        }
    }
}

@Composable
fun ApplyCoupon(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(text = "Informations personnelles", fontSize = 16.sp, fontWeight = FontWeight.Bold)

        val activity = context as Activity
        // on below line creating a variable for battery status
        val dateCmd = "now()"

        val userId = "abdel"

        val platId = "Sauce gombo"
        val noms = remember {
            mutableStateOf(TextFieldValue())
        }
        val phone = remember {
            mutableStateOf(TextFieldValue())
        }
        val email = remember {
            mutableStateOf(TextFieldValue())
        }
        val role = "client"

//    call instance of DataBase
        val dbHandler: DBHandler = DBHandler(context)
//      Form Design
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 5.dp),

        ) {

            Text(
                text = "Noms",
                style  = TextStyle(
                    textAlign = TextAlign.Left,
                ),
                color = dark_gray,
                modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
            )

            TextField(
                value = noms.value,
                onValueChange = { noms.value = it },
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
                placeholder = { Text(text = "Entrer votre nom et prenom") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = white,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "Nom et prenom") },
                shape = RoundedCornerShape(8.dp),

                ) //End of TextField Email

            Text(
                text = "email",
                style  = TextStyle(
                    textAlign = TextAlign.Left,
                ),
                color = dark_gray,
                modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
            )

            TextField(
                value = email.value,
                onValueChange = { email.value = it },
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
                label = { Text(text = "Votre email") },
                shape = RoundedCornerShape(8.dp),

                ) //End of TextField

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
                value = phone.value,
                onValueChange = { phone.value = it },
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
                label = { Text(text = "Numero de telephone") },
                shape = RoundedCornerShape(8.dp),

                ) //End of TextField

            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                onClick = {

//               Add infos User
                    dbHandler.addNewUser(
                        noms.value.text,
                        email.value.text,
                        phone.value.text,
                        role
                    )
//                Add infos order

                    dbHandler.addNewCommand(
                        dateCmd,
                        "1",
                        userId,
                        platId,
                    )

                    navControllerCK.navigate(Screen.ListMenuDashScreen.route)
                    Toast.makeText(context, "Ajout éffectue avec succès", Toast.LENGTH_SHORT).show()
                },

                colors = ButtonDefaults.buttonColors(backgroundColor = secondary),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 34.dp),

                ) {
                Text(
                    text = "Confirmer",
                    color = white,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )

            } //End of login Button
        }

    }
}

    @Composable
    fun ItemsCart() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(white)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.3f)
                        .height(70.dp)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sauce_gombo),
                        contentDescription = "", modifier = Modifier.size(70.dp)
                    )

                }

                Column(
                    modifier = Modifier
                        .weight(0.9f)
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Text(
                        text = "Couscous sauce Gombo",
                        fontSize = 16.sp,
                        color = black,
                        fontWeight = FontWeight.Bold
                    )

                    Text(text = "2 500 FCA", fontSize = 16.sp, color = secondary)

                    val counterCart = remember { mutableStateOf(1) }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Quantité:",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(top = 10.dp)
                        )

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(secondary)
                                .size(32.dp, 32.dp), contentAlignment = Alignment.Center
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_baseline_minimize_24),
                                    contentDescription = "",
                                    modifier = Modifier.padding(bottom = 15.dp),
                                    tint = white
                                )
                            }
                        }

                        Text(
                            text = "${counterCart.value}",
                            color = secondary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(secondary)
                                .size(32.dp, 32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(onClick = { counterCart.value++ }) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "",
                                    tint = white,
                                    modifier = Modifier.size(20.dp, 20.dp)
                                )
                            }
                        }

                    }
                }

            }
        }
    }

    @Composable
    fun HeaderCartItems() {
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navControllerCK.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = white,
                    modifier = Modifier.size(32.dp, 32.dp)
                )

            }

            Text(
                text = "Votre Commande",
                color = white,
                modifier = Modifier.padding(end = 150.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

        } //End Row
    }
