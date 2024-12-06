package com.example.esl.ui.screen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FileUpload
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import com.example.esl.ui.theme.BarColor
import com.example.esl.ui.theme.ButtonColors
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.tooling.preview.Preview
import com.example.esl.ui.theme.ESLTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PemesananScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pemesanan") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BarColor, // Warna biru
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) { innerPadding -> // Use the provided innerPadding
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding) // Apply innerPadding here
                .background(Color(0xFFB2DFDB))
        ) {
            DetailKendaraan()
            Spacer(modifier = Modifier.height(16.dp))
            FormField(label = "Durasi", value = "3 hari")
            FormField(label = "Mulai", value = "15.00 WIB")
            FormField(label = "Harga", value = "Rp. 250.000,-")
            Spacer(modifier = Modifier.height(16.dp))
            MetodePembayaranDropdown()
            Spacer(modifier = Modifier.height(16.dp))
            UploadFileButton()
            Spacer(modifier = Modifier.height(24.dp))
            PesanButton()
        }
    }
}


@Composable
fun DetailKendaraan() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text("Motor Vespa Biru", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text("Bk 1234 BC", fontSize = 14.sp)
            Text("Pasar Onilin", fontSize = 14.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormField(label: String, value: String) {
    Column {
        Text(label, fontSize = 14.sp, color = Color.Gray)
        TextField(
            value = value,
            onValueChange = {},
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
//            colors = TextFieldDefaults.textFieldColors(
//                containerColor = Color.White,
//                disabledIndicatorColor = Color.Transparent,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
            )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MetodePembayaranDropdown() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Shopeepay") }

    Column {
        Text("Metode Pembayaran", fontSize = 14.sp, color = Color.Gray)
        Box {
            TextField(
                value = selectedOption,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
//                colors = TextFieldDefaults.textFieldcolors(
//                    containerColor = Color.White,
//                    disabledIndicatorColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent
//                ),
                trailingIcon = {
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
                },
                enabled = false
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf("Shopeepay", "Gopay", "Transfer Bank").forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedOption = option
                            expanded = false
                        })
                }
            }
        }
    }
}

@Composable
fun UploadFileButton() {
    Column {
        Text("Bukti Pembayaran", fontSize = 14.sp, color = Color.Gray)
        OutlinedButton(
            onClick = { /* Handle upload */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            Icon(Icons.Filled.FileUpload, contentDescription = "Upload")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Upload File")
        }
    }
}

@Composable
fun PesanButton() {
    Button(
        onClick = { /* Handle pesan */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = ButtonColors)
    ) {
        Text("Pesan", color = Color.White, fontSize = 16.sp)
    }
}

@Preview
@Composable
private fun PemesananPrev() {
    ESLTheme {
        PemesananScreen()
    }
}