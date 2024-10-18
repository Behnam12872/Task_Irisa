package com.example.myapplication.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.data.model.AppScreen

@Composable
fun LoginScreen(navController: NavController) {
    Box {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconApp()
            MainCardView(navController)
        }
    }
}

@Composable
fun IconApp() {
    Image(
        modifier = Modifier
            .padding(14.dp)
            .clip(CircleShape)
            .size(180.dp),
        painter = painterResource(id = R.drawable.logo_irisa),
        contentDescription = null
    )
}
@Composable
fun MainCardView(navigation: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(
            modifier = Modifier.background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = White,
                modifier = Modifier.padding(top = 18.dp, bottom = 18.dp),
                text = stringResource(id = R.string.log_in),
                style = TextStyle(color = Blue, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            )
            UsernameTextField(username) { username = it }
            PasswordTextField(password) { password = it }
            Button(
                onClick = {
                    if (username == "admin" && password == "admin") {
                        navigation.navigate(AppScreen.HomeScreen) {
                            popUpTo(AppScreen.LoginScreen) {
                                inclusive = true
                            }
                        }
                    } else
                        Toast.makeText(
                            context,
                            "UserName OR Password Incorrect!",
                            Toast.LENGTH_SHORT
                        ).show()

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp)
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(id = R.string.log_in)
                )
            }
        }
    }
}
@Composable
fun UsernameTextField(username: String, onUsernameChanges: (String) -> Unit) {
    OutlinedTextField(
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = null,
                tint = White
            )
        },
        label = {
            Text(
                text = stringResource(id = R.string.username)
            )
        },
        value = username,
        onValueChange = onUsernameChanges,
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.Black,
        ),
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 16.dp),
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
    )
}

@Composable
fun PasswordTextField(password: String, onPasswordChange: (String) -> Unit) {
    val passwordVisible = remember { mutableStateOf(false) }
    OutlinedTextField(
        label = {
            Text(
                text = stringResource(id = R.string.password)
            )
        },
        value = password,
        onValueChange = onPasswordChange,
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.Black,
        ),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(1f),
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_password),
                contentDescription = null,
                tint = White
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_visible),
                contentDescription = null,
                tint = White,
                modifier = Modifier.clickable { passwordVisible.value = !passwordVisible.value })
        }
    )
}
