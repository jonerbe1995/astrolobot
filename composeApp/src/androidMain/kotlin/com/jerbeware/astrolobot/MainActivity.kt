package com.jerbeware.astrolobot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppEntryPoint() 
        }
    }
}

@Composable
fun AppEntryPoint() {
    App() // This calls the App function in your commonMain/App.kt
}