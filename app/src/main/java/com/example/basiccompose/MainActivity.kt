package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.estimateAnimationDurationMillis
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            // A painter is an object that represents something that can be drawn on the screen, essentially acting as a way to load and display an image or drawable to the screen
//            val constraints = ConstraintSet {
//                // We create the ref for the composable
//                val redBox = createRefFor("redbox")
//                val greenBox = createRefFor("greenbox")
//
//                constrain(redBox) {
//                    top.linkTo(parent.top);
//                    start.linkTo(parent.start);
//                    width = Dimension.value(100.dp);
//                    height = Dimension.value(100.dp);
//                }
//
//                constrain(greenBox) {
//                    top.linkTo(parent.top);
//                    start.linkTo(redBox.end);
//                    width = Dimension.value(100.dp);
//                    height = Dimension.value(100.dp);
//                }
//            }
//
//            ConstraintLayout (constraints, modifier = Modifier.fillMaxSize()) {
//                Box (
//                    modifier = Modifier.background(Color.Red).layoutId("redBox")
//                )
//
//                Box (
//                    modifier = Modifier.background(Color.Green).layoutId("greenbox")
//                )
//            }

//            val painter = painterResource(id = R.drawable.mars_valley);
//            val description = "Mars Rover"
//            val title = "Mars Rover Perseverance"

//            Column (
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.SpaceEvenly,
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//
////                val color = remember { mutableStateOf(Color.Yellow) }
////                ImageCard(painter, description, title)
////                ColorBox(
////                    Modifier.weight(1f).fillMaxSize()
////                ) {
////                    color.value = it
////                }
////                Box(
////                    modifier = Modifier
////                        .background(color.value)
////                        .weight(1f)
////                        .fillMaxSize()
////                )
//
//            }
//            val scrollState = rememberScrollState()
//            Column (
//                modifier = Modifier
//                    .fillMaxSize()
//                    .verticalScroll(scrollState)
//            ) {
//                for (i in 1..50) {
//                    Text(
//                        text = "Item $i",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 16.dp)
//                    )
//                }
//            }

//            LazyColumn {
//                itemsIndexed(
//                    listOf(
//                        "This",
//                        "is",
//                        "Jetpack",
//                        "Compose"
//                    )
//                ) {
//                    index, string ->
//                    Text(
//                        text = "Item $string",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 16.dp)
//                    )
//                }
//            }

            var currentSizeState by remember {
                mutableStateOf(200.dp)
            }

            val size by animateDpAsState(
                targetValue = currentSizeState,
//                tween(
//                    durationMillis = 1500,
//                    delayMillis = 300,
//                    easing = LinearOutSlowInEasing
//                )

//                spring(
//                    Spring.DampingRatioHighBouncy
//                )

//                keyframes {
//                    durationMillis = 5000
//                    currentSizeState at 0 with LinearEasing
//                    currentSizeState * 1.5f at 2000 with FastOutLinearInEasing
//                    currentSizeState * 2f at 5000
//                }
            )

            val infiniteTransition = rememberInfiniteTransition()
            val color by infiniteTransition.animateColor(
                initialValue = Color.Red,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    tween(durationMillis = 2000),
                    repeatMode = RepeatMode.Reverse
                )
            )

            Box(modifier = Modifier.background(color).size(size), contentAlignment = Alignment.Center) {
                Button (onClick = { currentSizeState += 50.dp }) {
                    Text(text = "Increase Size")
                }
            }
        }
    }
}

@Composable
fun ColorBox (
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit,
) {

    Box (
        modifier = modifier
            .background(Color.Red)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }
    )
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

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp), contentAlignment = Alignment.BottomStart) {
                Text(
                    text = buildAnnotatedString {
                        withStyle (
                            style = SpanStyle (
                                color = Color.Red,
                                fontSize = 18.sp
                            )
                        ) {
                            append("M")
                        }

                        append("ars ")

                        withStyle(
                            style = SpanStyle (
                                color = Color.Red,
                                fontSize = 18.sp
                            )
                        ) {
                            append("R")
                        }

                        append("over ")

                        withStyle(
                            style = SpanStyle (
                                color = Color.Red,
                                fontSize = 18.sp
                            )
                        ) {
                            append("P")
                        }

                        append("erseverance")
                    },
                    style = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 16.sp),
                )
            }
        }
    }
}