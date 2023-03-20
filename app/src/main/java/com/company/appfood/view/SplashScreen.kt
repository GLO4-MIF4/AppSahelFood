package com.company.appfood.view

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.company.appfood.R
import com.company.appfood.navigation.Screen
import com.company.appfood.utils.Constants.SPLASH_SCREEN_DURATION
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreen(navController: NavController){
     val scale = remember {
         Animatable(0f) //Animation
     }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(
             targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    overshootInterpolator.getInterpolation(it)
                }
            )
        )
        delay(3000)
//      delay(SPLASH_SCREEN_DURATION)
        navController.popBackStack()
        navController.navigate(Screen.HomeScreen.route)
    }

    PreviewSplash()
}

@Composable
fun AnimatedSplash()
{
    var startAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
//        navController.navigate(Screen.LoginScreen.route)
    }
    PreviewSplash()
}


@Composable
fun PreviewSplash()
{

    Surface(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.splash_bg_old),
            contentDescription = "Splash  bg food",
            contentScale = ContentScale.FillWidth
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_splash_logo),
                contentDescription = "Logo splash ",
                contentScale = ContentScale.Crop,
            )
        }
    }
}


