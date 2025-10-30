package com.nexin.yanopsbangan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexin.yanopsbangan.R
import com.nexin.yanopsbangan.utils.ActiveText
import com.nexin.yanopsbangan.utils.ArmyGreen
import com.nexin.yanopsbangan.utils.ArmyOlive
import com.nexin.yanopsbangan.utils.CardSurface
import com.nexin.yanopsbangan.utils.HighlightYellow
import com.nexin.yanopsbangan.utils.TextPrimary
import com.nexin.yanopsbangan.utils.TextSecondary


// Left Component
@Composable
fun HistorySection(
   items: List<Triple<String, String, String>>,
   modifier: Modifier = Modifier
) {
   Column(
      modifier = modifier
         .border(2.dp, ArmyOlive, RoundedCornerShape(16.dp))
         .background(CardSurface, RoundedCornerShape(16.dp))
         .padding(16.dp)
   ) {
      // Header
      Row(
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
         Box(
            modifier = Modifier
               .size(28.dp)
               .background(ArmyGreen, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
         ) {
            Icon(
               painter = painterResource(id = R.drawable.ic_history), // sediakan vector ini
               contentDescription = null,
               tint = HighlightYellow,
               modifier = Modifier.size(16.dp)
            )
         }
         Text(
            "History Pengisian",
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            color = HighlightYellow,
            fontSize = 18.sp
         )
         Spacer(modifier = Modifier.weight(1f))
         // (opsional) badge jumlah entri
         if (items.isNotEmpty()) {
            Text(
               text = "${items.size}",
               color = ActiveText,
               fontSize = 12.sp,
               modifier = Modifier
                  .background(ArmyGreen, RoundedCornerShape(999.dp))
                  .padding(horizontal = 8.dp, vertical = 4.dp)
            )
         }
      }

      // Divider halus
      Box(
         Modifier
            .padding(top = 12.dp, bottom = 8.dp)
            .fillMaxWidth()
            .height(1.dp)
            .background(ArmyOlive.copy(alpha = 0.35f))
      )

      // List
      if (items.isEmpty()) {
         // Empty state dark-modern
         Column(
            modifier = Modifier
               .fillMaxWidth()
               .padding(12.dp)
               .border(1.dp, ArmyOlive.copy(0.4f), RoundedCornerShape(12.dp))
               .background(Color(0x0DFFFFFF), RoundedCornerShape(12.dp))
               .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
         ) {
            Icon(
               painter = painterResource(id = R.drawable.ic_inbox),
               contentDescription = null,
               tint = TextSecondary,
               modifier = Modifier.size(24.dp)
            )
            Text("Belum ada data", color = TextSecondary, fontSize = 12.sp)
         }
      } else {
         LazyColumn(
            modifier = Modifier
               .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
         ) {
            items(items.size) { idx ->
               val (tanggal, nama, jumlah) = items[idx]
               HistoryItem(tanggal, nama, jumlah)
            }
         }
      }
   }
}

@Composable
private fun HistoryItem(
   tanggal: String,
   nama: String,
   jumlah: String,
) {
   Row(
      modifier = Modifier
         .fillMaxWidth()
         .border(1.dp, ArmyOlive.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
         .background(CardSurface.copy(alpha = 0.9f), RoundedCornerShape(12.dp))
         .padding(12.dp),
      verticalAlignment = Alignment.CenterVertically
   ) {
      // Accent bar + avatar blok
      Box(
         modifier = Modifier
            .width(4.dp)
            .height(40.dp)
            .background(HighlightYellow, RoundedCornerShape(2.dp))
      )
      Spacer(Modifier.width(12.dp))

      // Info kiri
      Column(Modifier.weight(1f)) {
         Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
               painter = painterResource(id = R.drawable.ic_calendar),
               contentDescription = null,
               tint = TextSecondary,
               modifier = Modifier.size(14.dp)
            )
            Text(
               text = tanggal,
               color = TextSecondary,
               fontSize = 12.sp,
               modifier = Modifier.padding(start = 6.dp)
            )
         }
         Text(
            text = nama,
            color = TextPrimary,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 2.dp)
         )
      }

      // Jumlah (pill)
      Text(
         text = jumlah,
         color = HighlightYellow,
         fontFamily = FontFamily(Font(R.font.poppins_semibold)),
         fontSize = 13.sp,
         modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 6.dp)
      )
   }
}