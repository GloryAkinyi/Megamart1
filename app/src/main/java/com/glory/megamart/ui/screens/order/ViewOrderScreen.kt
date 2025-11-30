package com.glory.megamart.ui.screens.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.glory.megamart.data.OrderViewModel
import com.glory.megamart.navigation.ROUT_HOME
import com.glory.megamart.ui.theme.newOrange
import com.glory.megamart.ui.theme.newWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewOrdersScreen(navController: NavController) {

    //Scaffold

    var selectedIndex by remember { mutableStateOf(1) }

    Scaffold(

        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("View All Orders") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newOrange,
                    titleContentColor = newWhite,
                    navigationIconContentColor = newWhite,
                    actionIconContentColor = newWhite
                ),
                actions = {
                    IconButton(onClick = {}) { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription ="") }
                    IconButton(onClick = {}) { Icon(imageVector = Icons.Default.Info, contentDescription ="") }
                }

            )
        },



        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = newOrange
            ){
                
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
                containerColor = newOrange
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },

        //Contents

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                // .background(newOrange)
            ) {


                //Main Contents of the page






                val context = LocalContext.current
                val orderViewModel = remember { OrderViewModel(navController, context) }

// Fetch orders when screen loads
                LaunchedEffect(Unit) {
                    orderViewModel.fetchOrders()
                }

                Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

                    Text(
                        text = "All Orders"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn {
                        items(orderViewModel.ordersList) { order ->

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp),
                                elevation = CardDefaults.cardElevation(4.dp)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {

                                    Text(text = "Product: ${order.productName}")
                                    Text(text = "Quantity: ${order.quantity}")
                                    Text(text = "Price: ${order.price}")
                                    Text(text = "Address: ${order.address}")
                                    Text(text = "Status: ${order.status}")
                                    Text(text = "OrderID: ${order.orderId}", fontSize = 12.sp)
                                }
                            }

                        }
                    }
                }


            }
        }
    )

    //End of scaffold

}



