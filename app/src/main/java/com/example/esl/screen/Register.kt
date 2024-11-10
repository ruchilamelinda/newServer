package com.example.esl.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.esl.R
import com.example.esl.ui.theme.BackgroundColor
import com.example.esl.ui.theme.ButtonColors
import com.example.esl.ui.theme.ESLTheme

@Composable
fun Register(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var nik by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(top = 40.dp)
    ) {
        Text(
            text = "DAFTAR AKUN",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Spacer(modifier = Modifier.size(8.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(horizontal = 25.dp, vertical = 15.dp)
        ) {
            TextField(
                value = nama,
                onValueChange = { nama = it },
                singleLine = true,
                label = { Text(stringResource(R.string.Nama)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )

            TextField(
                value = nik,
                onValueChange = { nik = it },
                singleLine = true,
                label = { Text(stringResource(R.string.NIK)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )

            TextField(
                value = noHP,
                onValueChange = { noHP = it },
                singleLine = true,
                label = { Text(stringResource(R.string.noHP)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                singleLine = true,
                label = { Text(stringResource(R.string.email)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )

            TextField(
                value = username,
                onValueChange = { username = it },
                singleLine = true,
                label = { Text(stringResource(R.string.username)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                singleLine = true,
                label = { Text(stringResource(R.string.password)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Button(onClick = { /*TODO*/ },
            contentPadding = PaddingValues(16.dp),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(21.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonColors,
                contentColor = Color.Black // Warna text
            ),
        ) {
            Text(text = "Daftar",
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        Spacer(modifier = Modifier.size(15.dp))

        Text(text = "atau coba cara lain")

        Spacer(modifier = Modifier.size(12.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                    .padding(20.dp)
            ) {
            Image(
                painter = painterResource(R.drawable.gle),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(horizontal = 5.dp)
            )

            Spacer(modifier = Modifier.size(12.dp))

            Image(
                painter = painterResource(R.drawable.fb),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(horizontal = 5.dp)
            )
        }
    }
}

@Preview
@Composable
private fun RegisterPrev() {
    ESLTheme {
        Register()
    }
}