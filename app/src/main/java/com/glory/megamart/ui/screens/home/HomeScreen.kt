package com.glory.megamart.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.glory.megamart.R
import com.glory.megamart.navigation.ROUT_ITEM
import com.glory.megamart.ui.theme.newOrange

@Composable
fun Home(navController: NavController){

    //Main Layout
    Column(
        modifier = Modifier.fillMaxSize().padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

       // Image(
        //            painter = painterResource(id = R.drawable.sneaker),
        //            contentDescription = "sneaker",
        //            modifier = Modifier.size(300.dp).clip(shape = CircleShape),
        //            contentScale = ContentScale.Crop
        //        )



        //Row

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ){
            Image(
                painter =  painterResource(id = R.drawable.sneaker),
                contentDescription = "sneaker",
                modifier = Modifier.size(width = 200.dp, height = 300.dp).clip(shape = RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp))


            Image(
                painter =  painterResource(id = R.drawable.sneaker),
                contentDescription = "sneaker",
                modifier = Modifier.size(width = 200.dp, height = 300.dp).clip(shape = RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painter =  painterResource(id = R.drawable.sneaker),
                contentDescription = "sneaker",
                modifier = Modifier.size(width = 200.dp, height = 300.dp).clip(shape = RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))


            Image(
                painter =  painterResource(id = R.drawable.sneaker),
                contentDescription = "sneaker",
                modifier = Modifier.size(width = 200.dp, height = 300.dp).clip(shape = RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )



        }

        //End of Row


        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "SHOP.DISCOVER.TREND",
            fontSize = 30.sp,
            color = newOrange,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "We want to be the place to choose to come and buy that bag of coffee or the apple pie that will make priceless memories of life.Mega Mart offers quality fresh produce, dairy products, meat and fish, a roastery, and a bakery all under one roof, enabling our patrons to live ...",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                navController.navigate(ROUT_ITEM)
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(newOrange),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Let's Get Started")
        }







    }
    //End of main layout


}

@Composable
@Preview(showBackground = true)
fun HomePreview(){
    Home(rememberNavController())
}