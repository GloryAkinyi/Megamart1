package com.glory.megamart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.glory.megamart.ui.screens.about.About
import com.glory.megamart.ui.screens.auth.LoginScreen
import com.glory.megamart.ui.screens.auth.RegisterScreen
import com.glory.megamart.ui.screens.contact.ContactScreen
import com.glory.megamart.ui.screens.dashboard.AdminDashboardScreen
import com.glory.megamart.ui.screens.dashboard.DashboardScreen
import com.glory.megamart.ui.screens.home.Home
import com.glory.megamart.ui.screens.intent.IntentScreen
import com.glory.megamart.ui.screens.items.ItemScreen
import com.glory.megamart.ui.screens.order.OrderUploadScreen
import com.glory.megamart.ui.screens.order.ViewOrdersScreen
import com.glory.megamart.ui.screens.products.AddProductScreen
import com.glory.megamart.ui.screens.products.UpdateProductScreen
import com.glory.megamart.ui.screens.products.ViewProductScreen
import com.glory.megamart.ui.screens.scaffold.ScaffoldScreen
import com.glory.megamart.ui.screens.splash.SplashScreen
import com.glory.megamart.ui.screens.start.StartScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_ADD_PRODUCT
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            Home(navController)
        }

        composable(ROUT_ABOUT) {
            About(navController)
        }

        composable(ROUT_CONTACT) {
            ContactScreen(navController)
        }

        composable(ROUT_ITEM) {
            ItemScreen(navController)
        }

        composable(ROUT_SCAFFOLD) {
            ScaffoldScreen(navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }

        composable(ROUT_START) {
            StartScreen(navController)
        }

        composable(ROUT_REGISTER) {
            RegisterScreen(navController)
        }

        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }


        composable(ROUT_ADMINDASHBOARD) {
            AdminDashboardScreen(navController)
        }

        composable(ROUT_UPLOAD_ORDER) {
            OrderUploadScreen(navController)
        }


        composable(ROUTE_ADD_PRODUCT) { AddProductScreen(navController) }

        composable(ROUTE_VIEW_PRODUCTS) { ViewProductScreen(navController) }

        composable(
            ROUTE_UPDATE_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")!!
            UpdateProductScreen(navController, productId)
        }



        composable(ROUT_VIEW_ORDER) {
            ViewOrdersScreen(navController)
        }


    }
}