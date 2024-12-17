package com.example.app.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.esl.ui.component.BottomNavBar
import com.example.esl.ui.theme.ESLTheme


@Composable
fun FavoritScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavBar(navController = navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFB2EBF2))
                .padding(innerPadding) // Berikan padding dari Scaffold
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Header Section
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF00796B))
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Favorit",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                }

                // Favorit List Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FavoritItem(
                        title = "Nama Rumah",
                        name = "Rumah Tepi Danau",
                        date = "09/09/2024",
                        owner = "Ruchil"
                    )

                    FavoritItem(
                        title = "Nama Kendaraan",
                        name = "Motor Beat BA 1654 AB",
                        date = "10/09/2024",
                        owner = "Vioni"
                    )

                    FavoritItem(
                        title = "Nama Kendaraan",
                        name = "Sepeda Gunung",
                        date = "08/09/2024",
                        owner = "Vioni"
                    )
                }
            }
        }
    }
}


@Composable
fun FavoritItem(title: String, name: String, date: String, owner: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "$title : $name", style = MaterialTheme.typography.bodyLarge, fontSize = 16.sp)
            Text(text = "Tanggal : $date", style = MaterialTheme.typography.bodyMedium, fontSize = 14.sp)
            Text(text = "Pemilik : $owner", style = MaterialTheme.typography.bodyMedium, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Detail",
                modifier = Modifier.align(Alignment.End),
                color = Color(0xFF00796B),
                textAlign = TextAlign.Right,
                fontSize = 14.sp
            )
        }
    }
}

@Preview
@Composable
private fun FavoritPrev() {
    ESLTheme {
        val dummyNavController = androidx.navigation.compose.rememberNavController()
        FavoritScreen(navController = dummyNavController)
    }
}
