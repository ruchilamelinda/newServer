package com.example.esl.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.esl.ui.screen.Home
import com.example.esl.ui.theme.BarColor

//@Composable
//fun AppNavigation() {
//    // Membuat NavController
//    val navController = rememberNavController()
//
//    // Menyusun NavHost untuk mendefinisikan rute
//    NavHost(
//        navController = navController,
//        startDestination = "home" // Rute awal
//    ) {
//        // Rute ke halaman Home
//        composable("home") {
//            Home()
//        }
//
////        // Rute ke halaman lain (misalnya, Halaman Profil)
////        composable("profile") {
////            ProfileScreen(navController)
////        }
//    }
//}

@Composable
fun BottomNavBar(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    BottomAppBar(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp)),
        containerColor = BarColor,
        contentColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(
                icon = Icons.Default.Home,
                label = "Home",
                selected = currentRoute == "home",
                onClick = { navController.navigate("home") }
            )
            BottomNavItem(
                icon = Icons.Default.Search,
                label = "Search",
                selected = currentRoute == "search",
                onClick = { navController.navigate("search") }
            )
            BottomNavItem(
                icon = Icons.Default.List,
                label = "History",
                selected = currentRoute == "history",
                onClick = { navController.navigate("history") }
            )
            BottomNavItem(
                icon = Icons.Default.Person,
                label = "Profile",
                selected = currentRoute == "profile",
                onClick = { navController.navigate("profile") }
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            modifier = Modifier
                .size(40.dp),
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) Color(0xFF4CAF50) else Color.White // Hijau jika aktif, putih jika tidak
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val fakeNavController = rememberNavController()
    BottomNavBar(navController = fakeNavController)
}


