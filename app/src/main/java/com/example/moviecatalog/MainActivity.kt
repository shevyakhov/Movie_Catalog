package com.example.moviecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviecatalog.ui.theme.MovieCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieCatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EntryScreen()
                }
            }
        }
    }
}

@Composable
fun EntryScreen() {
    val image: Painter = painterResource(id = R.drawable.logo_ic)
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = image,
                contentDescription = "logo",
                modifier = Modifier.padding(top = 100.dp)
            )
            val text = stringResource(id = R.string.app_name)
            Text(
                text = text,
                color = MaterialTheme.colors.primary,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp, bottom = 50.dp)
            )
            LoginField(isPassword = true, "lab")
            LoginField(isPassword = true, "lab")

        }

    }
}

@Composable
fun LoginField(isPassword: Boolean, label: String) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = {
            val maxChar = 30
            if (it.length <= maxChar) text = it.replace("\n", "")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(20.dp)),
        placeholder = {
            Text(
                "",
                Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.primary,
            )
        },
        label = {
            Text(label, color = MaterialTheme.colors.primary)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            textColor = MaterialTheme.colors.primary

        ),
        maxLines = 1,
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieCatalogTheme {
        EntryScreen()
    }
}

@Preview
@Composable
fun Log() {
    MovieCatalogTheme {
        LoginField(isPassword = true, label = "pass")
    }
}