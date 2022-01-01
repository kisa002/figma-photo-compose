package com.haeyum.figmaphoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeyum.figmaphoto.ui.theme.FigmaPhotoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen()
        }
    }
}

@Composable
fun Screen() {
    FigmaPhotoTheme {
        Column(modifier = Modifier
            .fillMaxSize(1f)
            .background(Color.White)
            .padding(16.dp)) {
            Text(text = "Discover", fontSize = 36.sp, modifier = Modifier.padding(top = 32.dp))
            Text(text = "WHAT'S NEW TODAY", fontSize = 13.sp, modifier = Modifier.padding(top = 32.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(434.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                (0..5).forEach {
                    item {
                        DiscoverCard(modifier = Modifier.fillParentMaxWidth(), owner = "HolyKnight", message = "Wow, Fantastic baby: $it")
                    }
                }
            }
        }
    }
}

@Composable
fun DiscoverCard(modifier: Modifier, owner: String, message: String) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.discover1),
            contentDescription = "discover",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "profile",
                modifier = Modifier.size(20.dp)
            )
            Column {
                Text(text = String.format("@%s", owner), fontSize = 13.sp)
                Text(text = message, fontSize = 11.sp)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
fun ScreenPreview() {
    Screen()
}