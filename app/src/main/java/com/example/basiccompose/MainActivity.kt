package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // A painter is an object that represents something that can be drawn on the screen, essentially acting as a way to load and display an image or drawable to the screen
            val painter = painterResource(id = R.drawable.mars_valley);
            val description = "Mars Rover"
            val title = "Mars Rover Perseverance"

            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageCard(painter, description, title)

            }
        }
    }
}

@Composable
fun ImageCard (
    painter: Painter, // To be able to use images
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier // Default value is a empty modifier
) {
    Card (
        modifier = modifier.fillMaxWidth(0.6f),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(modifier = Modifier
            .height(300.dp)) {
            // Whatever we put first will be at the bottom of the stack
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
                )

            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 400f
                    )
                ))

            Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.BottomStart) {
                Text(
                    title,
                    style = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
        }
    }
}