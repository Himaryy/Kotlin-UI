package com.nexin.yanopsbangan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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

// Right Component
@Composable
fun RightControlSection(
   isPump1On: Boolean,
   isPump2On: Boolean,
   onTogglePump1: () -> Unit,
   onTogglePump2: () -> Unit,
   tempC: Double,
   humidity: Double,
   modifier: Modifier = Modifier
) {
   Column(
      modifier = modifier,
      verticalArrangement = Arrangement.spacedBy(16.dp)
   ) {
      Column(
         modifier = Modifier.weight(1f),
         verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
         PumpControlCard(
            label = "Pump 1",
            subLabel = "Fuel Pump",
            isOn = isPump1On,
            onToggle = onTogglePump1
         )
         PumpControlCard(
            label = "Pump 2",
            subLabel = "Fuel Pump",
            isOn = isPump2On,
            onToggle = onTogglePump2
         )



         SensorCard(tempC = tempC, humidity = humidity)
      }
   }
}

@Composable
fun PumpControlCard(
   label: String,
   subLabel: String = "Fuel Pump",
   isOn: Boolean,
   onToggle: () -> Unit,
) {
   val borderColor = if (isOn) Color(0xFF1E3C1E) else Color(0xFF202020)
   val background = Color(0xFF202020)
   val iconColor = if (isOn) Color(0xFF4CAF50) else Color(0xFF8E8E8E)

   Row(
      modifier = Modifier
         .fillMaxWidth()
         .border(2.dp, borderColor, RoundedCornerShape(16.dp))
         .background(background, RoundedCornerShape(16.dp))
         .padding(horizontal = 16.dp, vertical = 12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
   ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
         Box(
            modifier = Modifier
               .size(40.dp)
               .background(Color(0xFF2A2A2A), RoundedCornerShape(100.dp)),
            contentAlignment = Alignment.Center
         ) {
            Icon(
               painter = painterResource(id = R.drawable.gas_station),
               contentDescription = null,
               tint = iconColor,
               modifier = Modifier.size(18.dp)
            )
         }

         Column(Modifier.padding(start = 12.dp)) {
            Text(
               label,
               color = Color.White,
               fontFamily = FontFamily(Font(R.font.poppins_semibold)),
               fontSize = 16.sp
            )
            Text(
               text = subLabel,
               color = Color(0xFF9E9E9E),
               fontFamily = FontFamily(Font(R.font.poppins_regular)),
               fontSize = 12.sp
            )
         }
      }

      Switch(
         checked = isOn,
         onCheckedChange = { onToggle() },
         colors = SwitchDefaults.colors(
            checkedThumbColor = Color(0xFF4CAF50),
            checkedTrackColor = Color(0xFF2E7D32),
            uncheckedThumbColor = Color(0xFF9E9E9E),
            uncheckedTrackColor = Color(0xFF3A3A3A)
         )
      )
   }
}

@Composable
fun SensorCard(
   tempC: Double,
   humidity: Double,
) {
   Row(
      modifier = Modifier
         .fillMaxWidth()
         .border(2.dp, Color(0xFF2F2F2F), RoundedCornerShape(16.dp))
         .background(Color(0xFF202020), RoundedCornerShape(16.dp))
         .padding(16.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
   ) {
      // 🔹 SUHU
      Row(verticalAlignment = Alignment.CenterVertically) {
         Box(
            modifier = Modifier
               .size(48.dp)
               .background(Color(0xFF2A2A2A), RoundedCornerShape(100.dp)),
            contentAlignment = Alignment.Center
         ) {
            Icon(
               painter = painterResource(id = R.drawable.thermometer),
               contentDescription = "Temperature Icon",
               tint = Color(0xFF4CAF50),
               modifier = Modifier.size(24.dp)
            )
         }

         Column(modifier = Modifier.padding(start = 12.dp)) {
            Text(
               text = "Suhu",
               color = Color.Gray,
               fontFamily = FontFamily(Font(R.font.poppins_regular)),
               fontSize = 12.sp
            )
            Text(
               text = "${tempC}°C",
               color = Color(0xFF4CAF50),
               fontFamily = FontFamily(Font(R.font.poppins_bold)),
               fontSize = 16.sp
            )
         }
      }

      // 🔹 KELEMBABAN
      Row(verticalAlignment = Alignment.CenterVertically) {
         Box(
            modifier = Modifier
               .size(48.dp)
               .background(Color(0xFF2A2A2A), RoundedCornerShape(100.dp)),
            contentAlignment = Alignment.Center
         ) {
            Icon(
               painter = painterResource(id = R.drawable.ic_humidity),
               contentDescription = "Humidity Icon",
               tint = Color(0xFF03A9F4),
               modifier = Modifier.size(24.dp)
            )
         }

         Column(modifier = Modifier.padding(start = 12.dp)) {
            Text(
               text = "Kelembaban",
               color = Color.Gray,
               fontFamily = FontFamily(Font(R.font.poppins_regular)),
               fontSize = 12.sp
            )
            Text(
               text = "${humidity}%",
               color = Color(0xFF03A9F4),
               fontFamily = FontFamily(Font(R.font.poppins_bold)),
               fontSize = 16.sp
            )
         }
      }
   }
}

@Composable
fun inputValueNozel() {

}