package com.glory.megamart.ui.screens.items

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.glory.megamart.R
import com.glory.megamart.navigation.ROUT_SCAFFOLD
import com.glory.megamart.ui.theme.newOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemScreen(navController: NavController){

    //Main Layout
    Column(
        modifier = Modifier.fillMaxSize()
    ){

        //TopAppBar
        TopAppBar(
            title = { Text(text = "Products") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = newOrange,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White
            ),
            navigationIcon = {
                IconButton(onClick = {}) { Icon(imageVector = Icons.Default.Menu, contentDescription ="menu") }
            },
            actions = {
                IconButton(onClick = {}) { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription ="") }
                IconButton(onClick = {}) { Icon(imageVector = Icons.Default.Info, contentDescription ="") }
                IconButton(onClick = { navController.navigate(ROUT_SCAFFOLD) }) { Icon(imageVector = Icons.Default.ArrowForward, contentDescription ="") }
            }

        )

        //End of TopAppbar

        Image(
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = "sneaker",
            modifier = Modifier.height(250.dp).fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        //End

        Spacer(modifier = Modifier.height(10.dp))

        //Searchbar

        var search by remember { mutableStateOf("") }


        OutlinedTextField(
            value = search,
            onValueChange = {  search = it },
            modifier = Modifier
                .width(350.dp)
                .align(alignment = Alignment.CenterHorizontally),
            leadingIcon = {  Icon(imageVector = Icons.Default.Search, contentDescription = "search") },
            label = {  Text(text = "Search Products....") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = newOrange,
                unfocusedBorderColor = Color.DarkGray
            )
        )

        //End of Searchbar

        Spacer(modifier = Modifier.height(10.dp))


        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ){


            //Card

            Card(
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(200.dp).padding(10.dp),
                //   colors = CardDefaults.cardColors(newOrange)
                elevation = CardDefaults.cardElevation(5.dp)
            ) {

                Row(
                    modifier = Modifier.padding(5.dp)
                ){

                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "",
                        modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(text = "Shirt", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Brand : Alexander", fontSize = 15.sp)
                        Text(text = "Size : XXL", fontSize = 15.sp)
                        Text(text = "Material : 100% Cotton", fontSize = 15.sp)
                        Text(text = "Ksh.20000", fontSize = 15.sp, color = newOrange)
                        Row {
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                        }
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(newOrange),
                        ) {
                            Text(text = "Add To Cart")
                        }

                    }

                }



            }

            //End of card


            Spacer(modifier = Modifier.height(10.dp))


            //Card

            Card(
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(200.dp).padding(10.dp),
                //   colors = CardDefaults.cardColors(newOrange)
                elevation = CardDefaults.cardElevation(5.dp)
            ) {

                Row(
                    modifier = Modifier.padding(5.dp)
                ){

                    Image(
                        painter = painterResource(id = R.drawable.sneaker),
                        contentDescription = "",
                        modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(text = "Shirt", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Brand : Alexander", fontSize = 15.sp)
                        Text(text = "Size : XXL", fontSize = 15.sp)
                        Text(text = "Material : 100% Cotton", fontSize = 15.sp)
                        Text(text = "Ksh.20000", fontSize = 15.sp, color = newOrange)
                        Row {
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                        }
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(newOrange),
                        ) {
                            Text(text = "Add To Cart")
                        }

                    }


                }



            }

            //End of card

            Spacer(modifier = Modifier.height(10.dp))


            //Card

            Card(
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(200.dp).padding(10.dp),
                //   colors = CardDefaults.cardColors(newOrange)
                elevation = CardDefaults.cardElevation(5.dp)
            ) {

                Row(
                    modifier = Modifier.padding(5.dp)
                ){

                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "",
                        modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(text = "Shirt", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Brand : Alexander", fontSize = 15.sp)
                        Text(text = "Size : XXL", fontSize = 15.sp)
                        Text(text = "Material : 100% Cotton", fontSize = 15.sp)
                        Text(text = "Ksh.20000", fontSize = 15.sp, color = newOrange)
                        Row {
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                            Icon(imageVector = Icons.Default.Star, contentDescription = "start", tint = newOrange)
                        }
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(newOrange),
                        ) {
                            Text(text = "Add To Cart")
                        }

                    }


                }



            }

            //End of card




        }







    }
    //End of layout

}

@Composable
@Preview(showBackground = true)
fun ItemScreenPreview(){
    ItemScreen(rememberNavController())
}