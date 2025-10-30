package com.nexin.yanopsbangan.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexin.yanopsbangan.R
import com.nexin.yanopsbangan.pages.NozzleState
import com.nexin.yanopsbangan.utils.ArmyGreen
import com.nexin.yanopsbangan.utils.ArmyOlive
import com.nexin.yanopsbangan.utils.BackgroundDark
import com.nexin.yanopsbangan.utils.CardSurface
import com.nexin.yanopsbangan.utils.DangerRed
import com.nexin.yanopsbangan.utils.HighlightYellow
import com.nexin.yanopsbangan.utils.SuccessGreen
import com.nexin.yanopsbangan.utils.TextPrimary
import com.nexin.yanopsbangan.utils.TextSecondary

// Center Component
@Composable
fun PanelMonitoring(
   isPump1On: Boolean,
   isPump2On: Boolean,
   pump1StatusText: String,
   pump2StatusText: String,
   nozzleStates: List<NozzleState>,
   modifier: Modifier = Modifier
) {
   Column(
      modifier = modifier
         .fillMaxHeight()
         .border(2.dp, ArmyOlive, RoundedCornerShape(16.dp))
         .background(CardSurface, RoundedCornerShape(16.dp))
         .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp)
   ) {
      Box(
         modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
         contentAlignment = Alignment.Center
      ) {
         Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
         ) {
            Box(
               modifier = Modifier
                  .size(32.dp)
                  .background(ArmyGreen, RoundedCornerShape(8.dp)),
               contentAlignment = Alignment.Center
            ) {
               Icon(
                  painter = painterResource(id = R.drawable.ic_monitor),
                  contentDescription = "Panel Monitor",
                  tint = HighlightYellow,
                  modifier = Modifier.size(18.dp)
               )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
               text = "Panel Monitoring",
               fontFamily = FontFamily(Font(R.font.poppins_semibold)),
               color = HighlightYellow,
               fontSize = 20.sp,
            )
         }
      }

      // PUMP LAYOUT
      Column(
         verticalArrangement = Arrangement.spacedBy(16.dp),
         modifier = Modifier.fillMaxWidth()
      ) {
         PumpVisualRow(
            pumpName = "Pump 1",
            left = nozzleStates[0],
            right = nozzleStates[1],
            pumpOn = isPump1On,
            statusText = pump1StatusText
         )

         PumpVisualRow(
            pumpName = "Pump 2",
            left = nozzleStates[2],
            right = nozzleStates[3],
            pumpOn = isPump2On,
            statusText = pump2StatusText
         )
      }

      Spacer(Modifier.height(0.dp))
   }
}

@Composable
fun PumpVisualRow(
   pumpName: String,
   left: NozzleState,
   right: NozzleState,
   pumpOn: Boolean,
   statusText: String,
   modifier: Modifier = Modifier
) {
   Row(
      modifier = modifier
         .fillMaxWidth()
         .border(1.dp, ArmyOlive.copy(0.4f), RoundedCornerShape(12.dp))
         .background(CardSurface, RoundedCornerShape(12.dp))
         .padding(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      verticalAlignment = Alignment.CenterVertically
   ) {
      HeliNozzleCard(state = left, modifier = Modifier.weight(1f))
      PumpCenterCard(
         pumpName = pumpName,
         pumpOn = pumpOn,
         statusText = statusText,
         modifier = Modifier.width(96.dp)
      )
      HeliNozzleCard(state = right, modifier = Modifier.weight(1f))
   }
}

// --- Kartu Heli + dua angka + progress
@Composable
fun HeliNozzleCard(state: NozzleState, modifier: Modifier = Modifier) {
   Column(
      modifier = modifier
         .border(1.dp, ArmyOlive.copy(0.3f), RoundedCornerShape(12.dp))
         .background(BackgroundDark.copy(0.6f), RoundedCornerShape(12.dp))
         .padding(12.dp)
   ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
         Box(
            modifier = Modifier
               .size(80.dp)
               .background(Color.White.copy(0.8f), RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
         ) {
            Image(
               painter = painterResource(id = R.drawable.apachef),
               contentDescription = "Apache Icon",
               modifier = Modifier
                  .size(80.dp)
                  .clip(RoundedCornerShape(8.dp))
            )
         }
         Text(
            text = state.label,
            color = TextPrimary,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 10.dp)
         )
      }

      Spacer(Modifier.height(10.dp))

      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
         Column {
            Text("Counter", color = TextSecondary, fontSize = 11.sp)
            Text(
               String.format("%.2f L", state.currentLiters),
               color = SuccessGreen,
               fontFamily = FontFamily(Font(R.font.poppins_semibold)),
               fontSize = 16.sp
            )
         }
         Column(horizontalAlignment = Alignment.End) {
            Text("Target", color = TextSecondary, fontSize = 11.sp)
            Text(
               String.format("%.2f L", state.targetLiters),
               color = HighlightYellow,
               fontFamily = FontFamily(Font(R.font.poppins_semibold)),
               fontSize = 16.sp
            )
         }
      }

      Spacer(Modifier.height(8.dp))

      val progress = if (state.targetLiters <= 0f) 0f
      else (state.currentLiters / state.targetLiters).coerceIn(0f, 1f)

      Box(
         modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .background(CardSurface, RoundedCornerShape(999.dp))
            .border(1.dp, ArmyOlive.copy(0.35f), RoundedCornerShape(999.dp))
      ) {
         Box(
            modifier = Modifier
               .fillMaxHeight()
               .fillMaxWidth(progress)
               .background(SuccessGreen, RoundedCornerShape(999.dp))
         )
      }
   }
}

// --- Tengah: ikon pompa + nama + lampu status (tanpa toggle)
@Composable
fun PumpCenterCard(
   pumpName: String,
   pumpOn: Boolean,
   statusText: String,
   modifier: Modifier = Modifier
) {
   Column(
      modifier = modifier
         .border(1.dp, ArmyOlive.copy(0.4f), RoundedCornerShape(16.dp))
         .background(CardSurface, RoundedCornerShape(16.dp))
         .padding(12.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(8.dp)
   ) {
      Box(
         modifier = Modifier
            .size(56.dp)
            .background(ArmyGreen, RoundedCornerShape(12.dp)),
         contentAlignment = Alignment.Center
      ) {
         Icon(
            painter = painterResource(id = R.drawable.gas_station),
            contentDescription = null,
            tint = HighlightYellow,
            modifier = Modifier.size(28.dp)
         )
      }
      Text(
         pumpName,
         color = TextPrimary,
         fontFamily = FontFamily(Font(R.font.poppins_semibold)),
         fontSize = 13.sp
      )
      Row(verticalAlignment = Alignment.CenterVertically) {
         Box(
            modifier = Modifier
               .size(10.dp)
               .background(if (pumpOn) SuccessGreen else DangerRed, CircleShape)
         )

         Spacer(modifier = Modifier.width(4.dp))

         Text(
            statusText,
            color = if (pumpOn) SuccessGreen else DangerRed,
            fontSize = 12.sp,
         )
      }
   }
}