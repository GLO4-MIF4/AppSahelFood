package com.company.appfood.view
import androidx.compose.foundation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.company.appfood.R
import com.company.appfood.navigation.Screen
import com.company.appfood.ui.theme.*


@Composable
fun LoginScreen(navController :NavController) {
    ViewLogin(navController = navController)
}


//@Preview(showBackground = true)

@Composable
fun ViewLogin(navController :NavController)
{

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
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
                Header()
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
                        .padding(30.dp)
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
                                    append("Renseigner les champs requis")
                                }
                            },
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center

                        )
                    }

                    Spacer(modifier = Modifier.padding(10.dp))

                    Text(

                        text = "Adresse mail",
                        style = MaterialTheme.typography.subtitle1,
                        color = dark_gray,
                        modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
                    )
                    var userEmail by remember{ mutableStateOf("") }

                    TextField(
                        value = userEmail,
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
                        }, //End of leadingIcon
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = white,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        label = { Text(text = "Email address") },
                        shape = RoundedCornerShape(8.dp),
                        onValueChange = {
                            userEmail = it
                        }

                    ) //End of TextField Email
                    Text(
                        text = "Mot de passe",
                        style = MaterialTheme.typography.subtitle1,
                        color = dark_gray,
                        modifier = Modifier.padding(
                            top = 10.dp,
                            bottom = 20.dp
                        )
                    )

                    var password by remember { mutableStateOf("") }
                    TextField(
                        value = password,
                        leadingIcon = {
                            Row(
                                modifier = Modifier.wrapContentWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.Lock,
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
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        label = { Text(text = "Password") },
                        shape = RoundedCornerShape(8.dp),
                        onValueChange = {
                            password = it
                        }
                    ) //End of TextField password

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Mot de passe oublié",
                            style = MaterialTheme.typography.subtitle2,
                            color = primary,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .clickable { }
                        )
                    } //End of Forgot password

                    Button(
                        onClick = {
                            navController.popBackStack()
                            navController.navigate(Screen.HomeDashbordScreen.route)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = secondary),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, bottom = 34.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "Se connecter",
                            color = white,
                            style = MaterialTheme.typography.button,
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                        )

                    } //End of login Button

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = buildAnnotatedString {
                            append("Vous n'avez pas de compte? S'inscrire")
                            addStyle(
                                SpanStyle(color = secondary),
                                23,
                                this.length
                            )
                        },
                            style = MaterialTheme.typography.subtitle1,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.clickable {

                            }

                        )
                    } //End of Register link

                } //End of Column

            }  //End of bloc surface

        } //end of ConstraintLayout
    }
}


@Composable
fun Header(){
    Image(
        painter = painterResource(id = R.drawable.splash_bg_old),
        contentDescription = "Login bg",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_splash_logo ),
            contentDescription = null,
            modifier = Modifier.wrapContentWidth()
        )

        Text(
            text = "Connexion",
            color = white,
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 2.sp
        )
    }
}