package com.glory.megamart.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.glory.megamart.R
import com.glory.megamart.data.AuthViewModel
import com.glory.megamart.navigation.ROUT_LOGIN
import com.glory.megamart.navigation.ROUT_REGISTER
import com.glory.megamart.ui.theme.newOrange

@Composable
fun LoginScreen(navController: NavController){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(newOrange),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.height(20.dp))

        // Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.cart))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Card
        Card(
            modifier = Modifier.fillMaxWidth().height(700.dp),
            shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
        ){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text(
                    text = "Megamart",
                    fontSize = 40.sp,
                    fontFamily = FontFamily.Cursive,
                    color = newOrange,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Welcome back! Login to continue",
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(10.dp))


                // Email Input
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.width(350.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = newOrange,
                        unfocusedLeadingIconColor = newOrange
                    ),
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = "") },
                    label = {  Text("Email") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Password Input
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.width(350.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = newOrange,
                        unfocusedLeadingIconColor = newOrange
                    ),
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "") },
                    label = {  Text("Password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Login Button
                val context = LocalContext.current
                val authViewModel = AuthViewModel(navController, context)

                Button(
                    onClick = {
                        authViewModel.login(email, password)
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(newOrange),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                ) {
                    Text(text = "Login")
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Navigate to Register
                TextButton(onClick = { navController.navigate(ROUT_REGISTER) }) {
                    Text(
                        text = "Don't have an account? Register",
                        color = Color.Blue
                    )
                }

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}
