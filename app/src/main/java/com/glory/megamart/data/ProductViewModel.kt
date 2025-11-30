package com.glory.megamart.data

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.glory.megamart.models.Product
import com.glory.megamart.navigation.ROUTE_VIEW_PRODUCTS
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.InputStream

class ProductViewModel : ViewModel() {

    private val cloudinaryUrl = "https://api.cloudinary.com/v1_1/ds8y1vfji/image/upload"
    private val uploadPreset = "megamart"

    private val _products = mutableStateListOf<Product>()
    val products: List<Product> = _products

    fun uploadProduct(
        imageUri: Uri?,
        name: String,
        category: String,
        brand: String,
        price: String,
        description: String,
        context: Context,
        navController: NavController
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val imageUrl = imageUri?.let { uploadToCloudinary(context, it) }
                val ref = FirebaseDatabase.getInstance().getReference("Products").push()
                val productData = mapOf(
                    "id" to ref.key,
                    "name" to name,
                    "category" to category,
                    "brand" to brand,
                    "price" to price,
                    "description" to description,
                    "imageUrl" to imageUrl
                )
                ref.setValue(productData).await()
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Product saved successfully", Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_VIEW_PRODUCTS)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Product not saved", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun uploadToCloudinary(context: Context, uri: Uri): String {
        val contentResolver = context.contentResolver
        val inputStream: InputStream? = contentResolver.openInputStream(uri)
        val fileBytes = inputStream?.readBytes() ?: throw Exception("Image read failed")
        val requestBody = MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart(
                "file", "image.jpg",
                RequestBody.create("image/*".toMediaTypeOrNull(), fileBytes)
            )
            .addFormDataPart("upload_preset", uploadPreset)
            .build()

        val request = Request.Builder().url(cloudinaryUrl).post(requestBody).build()
        val response = OkHttpClient().newCall(request).execute()
        if (!response.isSuccessful) throw Exception("Upload failed")
        val responseBody = response.body?.string()
        val secureUrl = Regex("\"secure_url\":\"(.*?)\"").find(responseBody ?: "")?.groupValues?.get(1)
        return secureUrl ?: throw Exception("Failed to get image URL")
    }

    fun fetchProducts(context: Context) {
        val ref = FirebaseDatabase.getInstance().getReference("Products")
        ref.get().addOnSuccessListener { snapshot ->
            _products.clear()
            for (child in snapshot.children) {
                val product = child.getValue(Product::class.java)
                product?.let {
                    it.id = child.key
                    _products.add(it)
                }
            }
        }.addOnFailureListener {
            Toast.makeText(context, "Failed to load products", Toast.LENGTH_LONG).show()
        }
    }

    fun deleteProduct(productId: String, context: Context) {
        val ref = FirebaseDatabase.getInstance().getReference("Products").child(productId)
        ref.removeValue().addOnSuccessListener {
            _products.removeAll { it.id == productId }
        }.addOnFailureListener {
            Toast.makeText(context, "Product not deleted", Toast.LENGTH_LONG).show()
        }
    }

    fun updateProduct(
        productId: String,
        imageUri: Uri?,
        name: String,
        category: String,
        brand: String,
        price: String,
        description: String,
        context: Context,
        navController: NavController
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val imageUrl = imageUri?.let { uploadToCloudinary(context, it) }
                val updateProduct = mapOf(
                    "id" to productId,
                    "name" to name,
                    "category" to category,
                    "brand" to brand,
                    "price" to price,
                    "description" to description,
                    "imageUrl" to imageUrl
                )
                val ref = FirebaseDatabase.getInstance().getReference("Products").child(productId)
                ref.setValue(updateProduct).await()
                fetchProducts(context)
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Product updated successfully", Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_VIEW_PRODUCTS)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Update failed", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
