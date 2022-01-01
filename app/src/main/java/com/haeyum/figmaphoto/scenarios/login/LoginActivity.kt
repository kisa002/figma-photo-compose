package com.haeyum.figmaphoto.scenarios.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haeyum.figmaphoto.MainActivity
import com.haeyum.figmaphoto.R
import com.haeyum.figmaphoto.scenarios.login.ui.theme.FigmaPhotoTheme
import com.haeyum.figmaphoto.utils.ToastHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen(
                onClickBack = {
                    finish()
                }, onClickNext = { email, password ->
                    startActivity(Intent(this, MainActivity::class.java))
                    ToastHelper.showToast("email: $email\npassword: $password")
                }
            )
        }
    }
}

@Composable
fun Screen(onClickBack: () -> Unit, onClickNext: (String, String) -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()
    val focusRequester = FocusRequester()

    com.haeyum.figmaphoto.scenarios.register.ui.theme.FigmaPhotoTheme {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            IconButton(onClick = onClickBack, modifier = Modifier.size(12.dp, 11.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "back",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
            Text(
                text = "Login",
                fontSize = 32.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 32.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                placeholder = {
                    Text(text = "email", color = Color.LightGray)
                },
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .focusRequester(focusRequester),
                shape = RectangleShape,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                placeholder = {
                    Text(text = "password", color = Color.LightGray)
                },
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                shape = RectangleShape,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            Button(
                onClick = { onClickNext(email, password) },
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            ) {
                Text(
                    text = "NEXT",
                    color = Color.White,
                    fontWeight = FontWeight(900),
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }

    DisposableEffect(Unit) {
        coroutineScope.launch {
            delay(300L)
            focusRequester.requestFocus()
        }
        onDispose {  }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
fun ScreenPreview() {
    Screen({}, {email, password -> })
}