package com.example.esl.ui.screen

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.esl.MainActivity
import com.example.esl.ui.theme.ESLTheme
import com.example.esl.R


@Composable
fun LandingPage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.logoesl)
    val context = LocalContext.current
    // Timer untuk berpindah ke MainActivity setelah beberapa detik
    LaunchedEffect(Unit) {
//        delay(3000L) // Tampilkan selama 3 detik
        // Pindah ke MainActivity setelah delay
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
        (context as Activity).finish() // Tutup LandingActivity agar tidak kembali saat tombol back ditekan
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
            {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(200.dp)
                        .fillMaxSize(),
                )
            }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingPreview(){
    ESLTheme {
        LandingPage()
    }
}