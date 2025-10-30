package com.nexin.yanopsbangan.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexin.yanopsbangan.R
import com.nexin.yanopsbangan.utils.ArmyGreen
import com.nexin.yanopsbangan.utils.BackgroundDark
import com.nexin.yanopsbangan.utils.HighlightYellow

@Composable
fun Homepage(modifier: Modifier = Modifier) {
   var isPumpActive by remember { mutableStateOf(false) }
   var currentPage by rememberSaveable { mutableStateOf("pengisian") }

   Scaffold(
      modifier = modifier
         .fillMaxSize()
         .background(BackgroundDark),
      topBar = {
         HeaderSection(
            currentPage = currentPage,
            onNavigate = { page -> currentPage = page },
            onLogout = {}
         )
      },
      containerColor = BackgroundDark
   ) { innerPadding ->
      // Konten di bawah header, otomatis tidak tertutup
      Box(
         modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
      ) {
         when (currentPage) {
            "pengisian" -> PengisianBbmScreen()
            "riwayat" -> RiwayatPengisianScreen()
         }
      }
   }
}

@Composable
fun HeaderSection(
   currentPage: String,
   onNavigate: (String) -> Unit,
   onLogout: () -> Unit
) {
   Box(
      modifier = Modifier
         .fillMaxWidth()
         .height(90.dp)
         .background(ArmyGreen)
         .padding(horizontal = 24.dp),
      contentAlignment = Alignment.Center
   ) {
      Row(
         verticalAlignment = Alignment.CenterVertically
      ) {
         Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
         ) {
            // Left Item
            Row(
               verticalAlignment = Alignment.CenterVertically
            ) {
               Image(
                  painter = painterResource(id = R.drawable.logo_puspenerbad),
                  contentDescription = "Logo",
                  modifier = Modifier
                     .size(64.dp)
                     .padding(end = 12.dp)
               )
               Column {
                  Text(
                     text = "AeroFuel",
                     fontFamily = FontFamily(Font(R.font.poppins_bold)),
                     color = HighlightYellow,
                     fontSize = 28.sp
                  )
               }
            }

            // Center Item
            Row(
               horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
               HeaderNavButton(
                  label = "Pengisian BBM",
                  isActive = currentPage == "pengisian",
                  onClick = { onNavigate("pengisian") }
               )

               HeaderNavButton(
                  label = "Riwayat Pengisian",
                  isActive = currentPage == "riwayat",
                  onClick = { onNavigate("riwayat") }
               )
            }

            // Right Item
            Row(
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
               IconButton(onClick = onLogout) {
                  Icon(
                     painter = painterResource(id = R.drawable.ic_logout),
                     contentDescription = "Logout",
                     tint = Color.White,
                     modifier = Modifier.size(28.dp)
                  )
               }
            }
         }
      }
   }
}

@Composable
fun HeaderNavButton(label: String, isActive: Boolean, onClick: () -> Unit) {
   TextButton(onClick = onClick) {
      Text(
         text = label,
         color = if (isActive) HighlightYellow else Color.White,
         fontFamily = FontFamily(Font(R.font.poppins_semibold)),
         fontSize = 16.sp
      )
   }
}