package com.example.esl.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.esl.ui.theme.BackgroundColor
import com.example.esl.ui.theme.BarColor
import com.example.esl.ui.theme.ButtonColors
import com.example.esl.ui.theme.ESLTheme

@Composable
fun CancelRent(modifier: Modifier = Modifier) {
    var selectedOption by remember { mutableStateOf("") }
    var otherReason by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
        .background(BackgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(BarColor)
                .padding(25.dp)
        ) {
            Text(
                text = "Alasan Pembatalan",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopStart),
                color = Color.White

            )
        }

        // Content
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val cancelOptions = listOf(
                "Harga sewa terlalu mahal",
                "Kondisi properti yang buruk",
                "Ingin mengubah pesanan",
                "Berubah pikiran/ada rencana lain",
                "Lainnya"
            )

            cancelOptions.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = selectedOption == option,
                            onClick = { selectedOption = option }
                        )
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option }
                    )
                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 8.dp),
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

            if (selectedOption == "Lainnya") {
                // Custom TextField instead of OutlinedTextField
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(Color.White)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    TextField(
                        value = otherReason,
                        onValueChange = { otherReason = it },
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                    )
                    if (otherReason.isEmpty()) {
                        Text(
                            "Masukkan alasan lainnya",
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                    }
                }
            }

        }

        Row (
            modifier = Modifier
                .padding(bottom = 100.dp)
        ){
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(15.dp)
                    .shadow(5.dp, shape = RoundedCornerShape(25.dp)),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray)
            ) {
                Text(text = "Kembali")
            }
            Button(onClick = { /*TODO*/ },

                modifier = Modifier
                    .padding(15.dp)
                    .shadow(5.dp, shape = RoundedCornerShape(25.dp)),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonColors,
                    contentColor = Color.Black
                )
            )
                {
                Text(text = "Batalkan Pesanan")
            }
        }
    }
}

@Preview
@Composable
private fun CancelPrev() {
    ESLTheme {
        CancelRent()
    }
}