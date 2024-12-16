package com.example.esl.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RentalScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Status", "Riwayat")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00B6D4))
    ) {
        // Bar Judul
        TitleBar()

        // Tab Navigation
        TabRow(selectedTabIndex = selectedTab, containerColor = Color.Transparent) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            color = if (selectedTab == index) Color(0xFF4CAF50) else Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
        }

        // Konten Tab
        when (selectedTab) {
            0 -> StatusPage()
            1 -> HistoryPage()
        }
    }
}

@Composable
fun TitleBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Riwayat Penyewaan",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun StatusPage() {
    Column(modifier = Modifier.padding(8.dp)) {
        RentalItemCard(
            status = "Sisa masa sewa : 1 Hari",
            itemName = "Rumah Singgah",
            date = "03/10/2024 - 16:00 WIB",
            owner = "Ruchi"
        )
        RentalItemCard(
            status = "Sisa masa sewa : 5 Jam",
            itemName = "Motor Vario BA 1234 BA",
            date = "02/10/2024 - 16:00 WIB",
            owner = "Viori"
        )
        RentalItemCard(
            status = "Sisa masa sewa : 5 Jam",
            itemName = "Sepeda Gunung",
            date = "02/10/2024 - 16:00 WIB",
            owner = "Matis"
        )
    }
}

@Composable
fun HistoryPage() {
    Column(modifier = Modifier.padding(8.dp)) {
        RentalItemCard(
            status = "Selesai",
            itemName = "Rumah Tepi Danau",
            date = "09/09/2024",
            owner = "Ruchi"
        )
        RentalItemCard(
            status = "Dibatalkan",
            itemName = "Motor Beat BA 1654 AB",
            date = "10/09/2024",
            owner = "Viori"
        )
        RentalItemCard(
            status = "Selesai",
            itemName = "Sepeda Gunung",
            date = "08/09/2024",
            owner = "Matis"
        )
    }
}

@Composable
fun RentalItemCard(
    status: String,
    itemName: String,
    date: String,
    owner: String
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            if (status == "Dibatalkan") Color.Red else Color(0xFF4CAF50),
                            shape = RoundedCornerShape(4.dp)
                        )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = status,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF004D40)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Nama Kendaraan/Kamar : $itemName", fontSize = 12.sp)
            Text(text = "Tanggal : $date", fontSize = 12.sp)
            Text(text = "Pemilik : $owner", fontSize = 12.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Detail",
                fontSize = 12.sp,
                color = Color(0xFF03A9F4),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRentalScreen() {
    RentalScreen()
}


@Preview(showBackground = true)
@Composable
fun PreviewRentalStatusScreen() {
    RentalScreen()
}
