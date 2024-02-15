package com.example.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.card.ui.theme.CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardTheme {
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

    Column(
        modifier = Modifier.padding(
            horizontal = 32.dp,
            vertical = 32.dp,
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.oruse),
            contentDescription = null,
            modifier = modifier,
        )
        Text(
            text = "Hello $name!",
            style = MaterialTheme.typography.displayMedium,
            modifier = modifier.padding(
                top = 16.dp,
            ),
        )
        Text(
            text = "Title",
            style = MaterialTheme.typography.labelLarge,
            modifier = modifier.padding(
                top = 16.dp,
            ),
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = 32.dp,
                start = 32.dp,
                end = 32.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(
            modifier = Modifier
                .padding(
                    top = 0.dp,
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                modifier = Modifier.padding(
                    start = 80.dp,
                ),
                painter = painterResource(
                    id = R.drawable.ic_android_black_24dp
                ),
                contentDescription = null
            )
            Text(
                text = "012",
                modifier = Modifier.padding(
                    start = 32.dp,
                )
            )
        }

        Row(
            modifier = Modifier
                .padding(
                    top = 32.dp,
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                modifier = Modifier.padding(
                    start = 80.dp,
                ),
                painter = painterResource(
                    id = R.drawable.ic_android_black_24dp
                ),
                contentDescription = null
            )
            Text(
                text = "3456",
                modifier = Modifier.padding(
                    start = 32.dp,
                )
            )
        }

        Row(
            modifier = Modifier
                .padding(
                    top = 32.dp,
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                modifier = Modifier.padding(
                    start = 80.dp,
                ),
                painter = painterResource(
                    id = R.drawable.ic_android_black_24dp
                ),
                contentDescription = null
            )
            Text(
                text = "78910",
                modifier = Modifier.padding(
                    start = 32.dp,
                )
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CardTheme {
        Greeting("Android")
    }
}