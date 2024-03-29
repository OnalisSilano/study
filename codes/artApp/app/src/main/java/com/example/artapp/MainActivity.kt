package com.example.artapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.artapp.ui.theme.ArtAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun AppearImage(,modifier: Modifier = Modifier) {
    Image(
        painter = "",
        contentDescription = ""
    )
}

@Composable
fun ImageTexts(modifier: Modifier = Modifier) {
    Text(text = "",
        modifier = modifier,
    )
}

@Composable
fun NextButton(modifier: Modifier = Modifier) {
    Button(onClick = { /*TODO*/ }) {

    }
}

@Composable
fun PreviousButton(modifier: Modifier = Modifier) {
    Button(onClick = { /*TODO*/ }) {

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtAppTheme {
        Greeting("Android")
    }
}