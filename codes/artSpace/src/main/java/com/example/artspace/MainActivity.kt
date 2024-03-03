package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
private fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    var artNumber by remember {
        mutableIntStateOf(1)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Images(
            modifier,
            artNumber,
        )
        Descriptions(
            modifier,
            artNumber,
        )
        Buttons(
            modifier,
            onClickPrevious = { previousNumber(artNumber = artNumber) },
            onClickNext = { nextNumber(artNumber = artNumber) },
        )
    }
}

@Composable
private fun Images(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
) {
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    Image(
        modifier = modifier
            .padding(
                top = 60.dp,
                start = 60.dp,
                end = 60.dp
            )
            .clip(RoundedCornerShape(16.dp))
            .border(
                BorderStroke(4.dp, rainbowColorsBrush)
            ),
        painter = painterResource(id = imageResource(image)), contentDescription = null
    )
}

@Composable
private fun Descriptions(
    modifier: Modifier = Modifier,
    @StringRes artNumber: Int,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 60.dp)
            .background(Color.Gray, RoundedCornerShape(8.dp)),
    ) {
        Text(
            modifier = modifier.padding(
                top = 8.dp,
                start = 24.dp,
                end = 24.dp,
            ),
            text = stringResource(id = description(artNumber).first),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = modifier.size(16.dp))
        Text(
            text = stringResource(id = description(artNumber).second),
            modifier = modifier.padding(
                bottom = 16.dp,
                start = 24.dp,
                end = 24.dp,
            ),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun Buttons(
    modifier: Modifier = Modifier,
    onClickPrevious: (Int) -> Unit,
    onClickNext: (Int) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Button(
            shape = MaterialTheme.shapes.small,
            onClick = { onClickPrevious },
            modifier = modifier.padding(
                horizontal = 16.dp
            ),
        ) {
            Text(text = "Previous")
        }
        Spacer(modifier = modifier.size(32.dp))
        Button(
            shape = MaterialTheme.shapes.small,
            onClick = { onClickNext },
            modifier = modifier.padding(
                horizontal = 16.dp
            ),
        ) {
            Text(text = "Next")

        }
    }
}


private fun previousNumber(artNumber: Int): Int {
    return when (artNumber) {
        1 -> {
            3
        }

        2 -> {
            1
        }

        else -> {
            2
        }
    }
}

private fun nextNumber(artNumber: Int): Int {
    return when (artNumber) {
        1 -> {
            2
        }

        2 -> {
            3
        }

        else -> {
            1
        }
    }
}

private fun imageResource(artNumber: Int): Int {
    return when (artNumber) {
        1 -> {
            R.drawable.sea
        }

        2 -> {
            R.drawable.monariza
        }

        else -> {
            R.drawable.toga
        }
    }
}

private fun description(artNumber: Int): Pair<Int, Int> {
    return when (artNumber) {
        1 -> {
            Pair(
                R.string.sea_title,
                R.string.sea_desc
            )
        }

        2 -> {
            Pair(
                R.string.monariza_title,
                R.string.monariza_desc
            )
        }

        else -> {
            Pair(
                R.string.toga_title,
                R.string.toga_desc
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}