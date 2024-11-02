package com.example.esl.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.esl.ui.theme.ESLTheme
import com.example.esl.R


@Composable
fun LandingPage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.logoesl)
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