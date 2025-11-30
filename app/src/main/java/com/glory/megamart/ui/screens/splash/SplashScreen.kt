package com.glory.megamart.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.glory.megamart.R
import com.glory.megamart.navigation.ROUT_HOME
import com.glory.megamart.navigation.ROUT_LOGIN
import com.glory.megamart.navigation.ROUT_START
import com.glory.megamart.ui.theme.newOrange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch{
        delay(2000)
        navController.navigate(ROUT_LOGIN)

    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){




        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.cart))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition, progress,
            modifier = Modifier.size(300.dp)
        )

        Text(
            text = "Shop Smart. Live Better.",
            color = newOrange
        )


        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "Thousands of products at your fingertips.\nGreat deals. Fast delivery.",
            color = newOrange,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))


        CircularProgressIndicator(
            modifier = Modifier.padding(top = 24.dp),
            color = newOrange
        )












    }


}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {

    SplashScreen(rememberNavController())
}