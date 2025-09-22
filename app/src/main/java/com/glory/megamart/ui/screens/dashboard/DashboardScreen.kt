package com.glory.megamart.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.glory.megamart.R
import com.glory.megamart.navigation.ROUT_HOME
import com.glory.megamart.ui.theme.newOrange
import com.glory.megamart.ui.theme.newWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController){



    //Scaffold

    var selectedIndex by remember { mutableStateOf(1) }

    Scaffold(

        //TopBar
        topBar = {

        },



        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = newOrange
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Home") },
                    label = { Text("Login") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_HOME)
                    }
                )




            }
        },

        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */ },
                containerColor = newOrange,
                modifier = Modifier.offset(y=40.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,

        //Contents

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                // .background(newOrange)
            ) {


                //Main Contents of the page
                //Row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.height(200.dp).fillMaxWidth()
                ){

                    Column {
                        Text(
                            text = "Hi, Samantha",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Here are your projects",
                            fontSize = 15.sp
                        )
                    }


                    Image(
                        painter = painterResource(R.drawable.splash),
                        contentDescription = "",
                        modifier = Modifier.height(200.dp).width(100.dp)
                    )


                }
                //End of row








                Spacer(modifier = Modifier.height(10.dp))


                //Row
                Row(
                    modifier = Modifier.padding(start = 20.dp)
                        .horizontalScroll(rememberScrollState())
                ){

                    //Card

                    Card(
                        onClick = {},
                        colors = CardDefaults.cardColors(newOrange),
                        modifier = Modifier.height(250.dp).width(200.dp)
                    ) {
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ){


                            Image(
                                painter = painterResource(R.drawable.splash),
                                contentDescription = "",
                                modifier = Modifier.height(100.dp).width(100.dp)
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "CryptoCurrency",
                                fontSize = 15.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Landing Page",
                                fontSize = 15.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold
                            )


                        }
                    }
                    //End of card

                    Spacer(modifier = Modifier.width(10.dp))

                    //Card

                    Card(
                        onClick = {},
                        colors = CardDefaults.cardColors(Color.Green),
                        modifier = Modifier.height(250.dp).width(200.dp)
                    ) {
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ){


                            Image(
                                painter = painterResource(R.drawable.sneaker),
                                contentDescription = "",
                                modifier = Modifier.height(100.dp).width(100.dp)
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "CryptoCurrency",
                                fontSize = 15.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Landing Page",
                                fontSize = 15.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold
                            )


                        }
                    }
                    //End of card

                    Spacer(modifier = Modifier.width(10.dp))

                    //Card

                    Card(
                        onClick = {},
                        colors = CardDefaults.cardColors(Color.Yellow),
                        modifier = Modifier.height(250.dp).width(200.dp)
                    ) {
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ){


                            Image(
                                painter = painterResource(R.drawable.splash),
                                contentDescription = "",
                                modifier = Modifier.height(100.dp).width(100.dp)
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "CryptoCurrency",
                                fontSize = 15.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Landing Page",
                                fontSize = 15.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold
                            )


                        }
                    }
                    //End of card

                    Spacer(modifier = Modifier.width(10.dp))



                }

                //End of row

                Spacer(modifier = Modifier.height(20.dp))


                Text(
                    text = "Personal Tasks",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ){


                    //Card
                    Card(
                        modifier = Modifier.fillMaxWidth().height(100.dp).padding(start = 20.dp, end = 20.dp)
                    ){

                        Row(
                            modifier = Modifier.fillMaxSize().padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ){


                            Image(
                                painter = painterResource(R.drawable.sneaker),
                                contentDescription = "",
                                modifier = Modifier.height(50.dp).width(100.dp)
                            )

                            Column {

                                Text(
                                    text = "NDA Review for website projects",
                                    fontSize = 15.sp
                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today - 10 PM",
                                    fontSize = 15.sp
                                )

                            }

                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "",
                                tint = Color.Yellow
                            )

                        }

                    }
                    //End of card

                    Spacer(modifier = Modifier.height(10.dp))

                    //Card
                    Card(
                        modifier = Modifier.fillMaxWidth().height(100.dp).padding(start = 20.dp, end = 20.dp)
                    ){

                        Row(
                            modifier = Modifier.fillMaxSize().padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ){


                            Image(
                                painter = painterResource(R.drawable.img_1),
                                contentDescription = "",
                                modifier = Modifier.height(50.dp).width(100.dp)
                            )

                            Column {

                                Text(
                                    text = "NDA Review for website projects",
                                    fontSize = 15.sp
                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today - 10 PM",
                                    fontSize = 15.sp
                                )

                            }

                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "",
                                tint = Color.Yellow
                            )

                        }

                    }
                    //End of card

                    Spacer(modifier = Modifier.height(10.dp))

                    //Card
                    Card(
                        modifier = Modifier.fillMaxWidth().height(100.dp).padding(start = 20.dp, end = 20.dp)
                    ){

                        Row(
                            modifier = Modifier.fillMaxSize().padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ){


                            Image(
                                painter = painterResource(R.drawable.sneaker),
                                contentDescription = "",
                                modifier = Modifier.height(50.dp).width(100.dp)
                            )

                            Column {

                                Text(
                                    text = "NDA Review for website projects",
                                    fontSize = 15.sp
                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today - 10 PM",
                                    fontSize = 15.sp
                                )

                            }

                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "",
                                tint = Color.Yellow
                            )

                        }

                    }
                    //End of card


                }

























            }
        }
    )

    //End of scaffold



}

@Composable
@Preview(showBackground = true)
fun  DashboardScreenPreview(){
    DashboardScreen(rememberNavController())
}