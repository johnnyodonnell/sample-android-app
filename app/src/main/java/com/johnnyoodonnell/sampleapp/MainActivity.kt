package com.johnnyoodonnell.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.johnnyoodonnell.sampleapp.ui.theme.SampleAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Cyan) {
        Text(
            text = "Hello $name!",
            modifier = modifier.padding(24.dp)
        )
    }
}

// From https://developer.android.com/codelabs/basic-android-kotlin-compose-first-app#3
// "The GreetingPreview is a cool feature that lets you see what your
//     composable looks like without having to build your entire app.
//     ...
//     The `@Preview` annotation tells Android Studio that this
//     composable should be shown in the design view of this file.
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleAppTheme {
        Greeting("Android")
    }
}

