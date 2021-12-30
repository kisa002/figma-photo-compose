package com.haeyum.figmaphoto.scenarios.intro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haeyum.figmaphoto.R
import com.haeyum.figmaphoto.scenarios.intro.ui.theme.FigmaPhotoTheme
import com.haeyum.figmaphoto.scenarios.login.LoginActivity
import com.haeyum.figmaphoto.scenarios.register.RegisterActivity
import com.haeyum.figmaphoto.utils.ToastHelper

class IntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen(
                onClickLogin = { startActivity(Intent(this, LoginActivity::class.java)) },
                onClickRegister = { startActivity(Intent(this, RegisterActivity::class.java)) }
            )
        }
    }
}

@Composable
fun Screen(onClickLogin: () -> Unit, onClickRegister: () -> Unit) {
    FigmaPhotoTheme {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .weight(1f)
                    .padding(0.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bg_intro),
                    contentDescription = "intro background",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.matchParentSize()
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_splash_logo),
                    contentDescription = "intro logo",
                    modifier = Modifier
                        .width(206.dp)
                        .height(54.dp)
                        .align(Alignment.Center)
                )
            }
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp, 20.dp)
            ) {
                OutlinedButton(
                    onClick = onClickLogin,
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp),
                    shape = RoundedCornerShape(10),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = Color.Black
                    ),
                    border = BorderStroke(2.dp, Color.Black)
                ) {
                    Text(text = "LOG IN")
                }
                Spacer(modifier = Modifier.width(9.dp))
                Button(
                    onClick = onClickRegister,
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp),
                    shape = RoundedCornerShape(10),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "REGISTER")
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
fun ScreenPreview() {
    Screen({}, {})
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview2() {
//    FigmaPhotoTheme {
//        Greeting2("Android")
//    }
//}