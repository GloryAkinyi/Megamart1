package com.glory.megamart.ui.screens.order

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.glory.megamart.data.OrderViewModel
import com.glory.megamart.navigation.ROUT_HOME
import com.glory.megamart.ui.theme.newOrange
import com.glory.megamart.ui.theme.newWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderUploadScreen(navController: NavController) {

    var selectedIndex by remember { mutableStateOf(0) }

    // Create ViewModel safely
    val context = LocalContext.current
    val orderViewModel = remember { OrderViewModel(navController, context) }

    Scaffold(

        //Top Bar
        topBar = {
            TopAppBar(
                title = { Text("Order Now") },
                navigationIcon = {
                    IconButton(onClick = { /* navigate */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newOrange,
                    titleContentColor = newWhite,
                    navigationIconContentColor = newWhite,
                    actionIconContentColor = newWhite
                )
            )
        },

        //Bottom Bar
        bottomBar = {
            NavigationBar(containerColor = newOrange) {
             
                
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_HOME)
                    }
                )
            }
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Action */ },
                containerColor = newOrange
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) { paddingValues ->

        // Main Screen Content with padding from Scaffold
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            var productName by remember { mutableStateOf("") }
            var quantity by remember { mutableStateOf("") }
            var price by remember { mutableStateOf("") }
            var address by remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                OutlinedTextField(
                    value = productName,
                    onValueChange = { productName = it },
                    label = { Text("Product Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = quantity,
                    onValueChange = { quantity = it },
                    label = { Text("Quantity") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    label = { Text("Price") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = address,
                    onValueChange = { address = it },
                    label = { Text("Delivery Address") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        orderViewModel.uploadOrder(
                            productName,
                            quantity.toIntOrNull() ?: 1,
                            price.toDoubleOrNull() ?: 0.0,
                            address
                        )
                    },
                    colors = ButtonDefaults.buttonColors(newOrange)
                ) {
                    Text("Upload Order")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderUploadScreenPreview() {
    OrderUploadScreen(rememberNavController())
}
