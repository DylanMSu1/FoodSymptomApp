package com.example.foodapp.ui.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text // Make sure you have the correct Material Design import
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue // For observing LiveData
import androidx.compose.runtime.livedata.observeAsState // For observing LiveData
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.R // Make sure this import is correct

class FoodFragment : Fragment() {

    private lateinit var foodViewModel: FoodViewModel // Initialize in onCreateView or onViewCreated

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        return ComposeView(requireContext()).apply {
            setContent {
                // Observe the LiveData from the ViewModel
                val textToShow by foodViewModel.text.observeAsState("") // Provide an initial value

                // Your main Composable content for the fragment
                FoodScreenContent(textToShow)
            }
        }
    }

    // It's good practice to separate your screen content into its own Composable
    @Composable
    fun FoodScreenContent(text: String, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            FoodImage() // Call your FoodImage Composable
        }
    }

    @Composable
    fun FoodImage(modifier: Modifier = Modifier) {
        val imagePainter = painterResource(R.drawable.foodimage) // Assuming foodimage.png is in res/drawable
        Box(modifier = modifier) { // Pass the modifier to the Box
            Image(
                painter = imagePainter,
                contentDescription = "Food Image", // Provide a meaningful content description
                modifier = Modifier.size(200.dp), // Example size
                contentScale = ContentScale.Crop
            )
        }
    }
}
    