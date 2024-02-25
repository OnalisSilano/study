package com.example.lemonade2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade2.ui.theme.Lemonade2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lemonade2Theme {
                Lemonade2App()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Lemonade2App() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LemonadeScreen()
        }
    }
}

@Composable
fun LemonadeScreen() {
    var current by remember {
        mutableIntStateOf(1)
    }
    var squeeze by remember {
        mutableIntStateOf(0)
    }
    TextAndImage(currentViewInt = current,
        onClicks = {
            when (current) {
                1 -> {
                    current = 2
                    squeeze = (2..4).random()
                }

                2 -> {
                    squeeze--
                    if (squeeze == 0) {
                        current = 3
                    }
                }

                3 -> {
                    current = 4
                }

                else -> {
                    current = 1
                }
            }
        }
    )
}

@Composable
fun TextAndImage(
    currentViewInt: Int,
    onClicks: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (currentViewInt) {
            1 -> {
                TextImages(
                    painter = painterResource(id = R.drawable.lemon_tree),
                    contentDesc = stringResource(id = R.string.lemon_tree_alternative),
                    onClick = onClicks,
                    text = stringResource(id = R.string.select_lemon_label),
                )
            }

            2 -> {
                TextImages(
                    painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDesc = stringResource(id = R.string.lemon_alternative),
                    onClick = onClicks,
                    text = stringResource(id = R.string.squeeze_lemon_label)
                )
            }

            3 -> {
                TextImages(
                    painter = painterResource(id = R.drawable.lemon_drink),
                    contentDesc = stringResource(id = R.string.lemonade_alternative),
                    onClick = onClicks,
                    text = stringResource(id = R.string.drink_lemonade_label)
                )
            }

            else -> {
                TextImages(
                    painter = painterResource(id = R.drawable.lemon_restart),
                    contentDesc = stringResource(id = R.string.empty_glass_alternative),
                    onClick = onClicks,
                    text = stringResource(id = R.string.start_again_label)
                )
            }
        }
    }
}

@Composable
fun TextImages(
    painter: Painter,
    contentDesc: String?,
    onClick: () -> Unit,
    text: String,
) {
    Image(
        painter = painter,
        contentDescription = contentDesc,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(200.dp)
            .clickable(
            onClick = onClick,
        )
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(16.dp)
            ),
    )
    Text(
        text = text,
        modifier = Modifier.padding(
            top = 32.dp
        )
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lemonade2Theme {
        Lemonade2App()
    }
}