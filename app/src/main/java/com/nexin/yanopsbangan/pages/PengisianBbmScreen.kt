package com.nexin.yanopsbangan.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexin.yanopsbangan.components.HistorySection
import com.nexin.yanopsbangan.components.PanelMonitoring
import com.nexin.yanopsbangan.components.RightControlSection

data class NozzleState(
   val label: String,
   val targetLiters: Float,
   val currentLiters: Float
)

@Composable
fun PengisianBbmScreen() {
   var isPump1On by remember { mutableStateOf(false) }
   var isPump2On by remember { mutableStateOf(false) }

   val nozzleStates = remember {
      listOf(
         NozzleState("Nozel 1 (Heli A)", 100f, 65f),
         NozzleState("Nozel 2 (Heli B)", 100f, 30f),
         NozzleState("Nozel 3 (Heli C)", 80f, 75f),
         NozzleState("Nozel 4 (Heli D)", 120f, 120f),
      )
   }

   val history = remember {
      listOf(
         Triple("30 Okt 2025", "Capt. Ardi", "120 L"),
         Triple("30 Okt 2025", "Letda Raka", "85 L"),
         Triple("29 Okt 2025", "Sertu Dimas", "150 L"),
         Triple("29 Okt 2025", "Lettu Seno", "95 L"),
         Triple("30 Okt 2025", "Capt. Ardi", "120 L"),
         Triple("30 Okt 2025", "Letda Raka", "85 L"),
         Triple("29 Okt 2025", "Sertu Dimas", "150 L"),
         Triple("29 Okt 2025", "Lettu Seno", "95 L"),
         Triple("30 Okt 2025", "Capt. Ardi", "120 L"),
         Triple("30 Okt 2025", "Letda Raka", "85 L"),
         Triple("29 Okt 2025", "Sertu Dimas", "150 L"),
         Triple("29 Okt 2025", "Lettu Seno", "95 L"),
      )
   }

   Row(
      modifier = Modifier
         .fillMaxSize()
         .padding(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp)
   ) {
      // Left
      HistorySection(
         items = history,
         modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
      )

      // Center
      PanelMonitoring(
         isPump1On = isPump1On,
         isPump2On = isPump2On,
         pump1StatusText = if (isPump1On) "ON" else "OFF",
         pump2StatusText = if (isPump2On) "ON" else "OFF",
         nozzleStates = nozzleStates,
         modifier = Modifier.weight(2f)
      )

      // Right
      RightControlSection(
         isPump1On = isPump1On,
         isPump2On = isPump2On,
         onTogglePump1 = { isPump1On = !isPump1On },
         onTogglePump2 = { isPump2On = !isPump2On },
         tempC = 28.6,
         humidity = 64.0,
         modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
      )
   }
}




