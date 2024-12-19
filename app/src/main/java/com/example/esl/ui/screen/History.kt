package com.example.esl.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app.ui.screen.FavoritScreen
import com.example.esl.ui.component.BottomNavBar
import com.example.esl.ui.theme.ESLTheme


// Data class untuk riwayat penyewaan
data class RentalHistory(
    val status: String,
    val name: String,
    val date: String,
    val owner: String,
    val statusColor: Color
)

// Daftar dummy data riwayat penyewaan
val rentalData = listOf(
    RentalHistory("Selesai", "Rumah Tepi Danau", "09/09/2024", "Ruchil", Color.Red),
    RentalHistory("Dibatalkan", "Motor Beat BA 1654 AB", "10/09/2024", "Vioni", Color.Black),
    RentalHistory("Selesai", "Sepeda Gunung", "08/09/2024", "Ruchil", Color.Red)
)

@Composable
fun RiwayatScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavBar(navController) } // Berikan NavController ke BottomNavBar
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF2ED4D8))
                .padding(innerPadding)
        ) {
            Text(
                text = "Riwayat Penyewaan",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(rentalData) { rental ->
                    RentalCard(rental)
                }
            }
        }
    }
}

@Composable
fun RentalCard(rental: RentalHistory) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(rental.statusColor, RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = rental.status,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Nama ${if (rental.status == "Dibatalkan") "Kendaraan" else "Rumah"} : ${rental.name}",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Text(
                text = "Tanggal : ${rental.date}",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Text(
                text = "Pemilik : ${rental.owner}",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Detail",
                fontSize = 14.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
private fun HistoryPrev() {
    ESLTheme {
        val dummyNavController = androidx.navigation.compose.rememberNavController()
        RiwayatScreen(navController = dummyNavController)
    }
}
