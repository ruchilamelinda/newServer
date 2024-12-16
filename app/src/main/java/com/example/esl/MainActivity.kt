package com.example.esl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.app.ui.screen.FavoritScreen
import com.example.esl.ui.theme.ESLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ESLTheme {
                val navController = rememberNavController()
                FavoritScreen(navController = navController)
            }
        }
    }
}



