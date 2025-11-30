package com.glory.megamart.data


import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavController
import com.glory.megamart.models.Order
import com.glory.megamart.navigation.ROUT_VIEW_ORDER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class OrderViewModel(var navController: NavController, var context: Context) {

    private val mAuth = FirebaseAuth.getInstance()

    fun uploadOrder(productName: String, quantity: Int, price: Double, address: String) {

        val uid = mAuth.currentUser?.uid
        if (uid == null) {
            Toast.makeText(context, "User not logged in", Toast.LENGTH_LONG).show()
            return
        }

        val orderId = FirebaseDatabase.getInstance().reference.push().key!!

        val order = Order(
            orderId = orderId,
            userId = uid,
            productName = productName,
            quantity = quantity,
            price = price,
            address = address,
            status = "Pending"
        )

        val orderRef = FirebaseDatabase.getInstance().getReference("Orders/$orderId")

        orderRef.setValue(order).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(context, "Order Uploaded Successfully", Toast.LENGTH_LONG).show()
                navController.navigate(ROUT_VIEW_ORDER)
            } else {
                Toast.makeText(context, "Failed: ${it.exception?.message}", Toast.LENGTH_LONG).show()
            }
        }
    }


    //Fetch Order
    var ordersList = mutableStateListOf<Order>()

    fun fetchOrders() {
        val dbRef = FirebaseDatabase.getInstance().getReference("Orders")

        dbRef.get().addOnSuccessListener { snapshot ->
            ordersList.clear()

            for (orderSnap in snapshot.children) {
                val order = orderSnap.getValue(Order::class.java)
                if (order != null) {
                    ordersList.add(order)
                }
            }
        }
    }

}
