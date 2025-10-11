package com.nexin.yanopsbangan.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nexin.yanopsbangan.components.ButtonComponent
import com.nexin.yanopsbangan.components.CardStat
import com.nexin.yanopsbangan.utils.Breakpoint
import com.nexin.yanopsbangan.utils.ScreenInfo

@Composable
fun Homepage(modifier: Modifier = Modifier){
   Column(
      modifier.fillMaxSize()
         .background(Color(0xFFF4F4F4))

   ) {
      HeaderSection()

      Row (
         modifier = Modifier.fillMaxWidth()
            .weight(1f)
            .padding(16.dp),
         horizontalArrangement = Arrangement.spacedBy(16.dp),


      ){
         // Controller
         PanelController(
            modifier = Modifier.weight(1f).fillMaxHeight()
         )

         // Monitoring
         PanelMonitoring(modifier = Modifier
            .weight(2f)
            .fillMaxHeight())

//         PanelPump()
         PanelPump(modifier = Modifier
            .weight(1f))
      }
   }
}

@Composable
fun HeaderSection(){
   val screenInfo = ScreenInfo()

   val textStyle = when (screenInfo.breakpoint){
      Breakpoint.Small -> MaterialTheme.typography.headlineSmall
      Breakpoint.Medium -> MaterialTheme.typography.headlineMedium
      Breakpoint.Large -> MaterialTheme.typography.headlineLarge
   }

   Box(
      modifier = Modifier.fillMaxWidth()
         .height(180.dp)
         .background(MaterialTheme.colorScheme.primary),
      contentAlignment = Alignment.Center
   ){
      Text(
//         text = """
//               Control dan Monitoring Pengisian Bahan Bakar
//               Pesawat Udara YANOPSBANGAN TNI AD
//               """.trimIndent(),
         text = "PUSPENERBAD AD",
         style = textStyle,
         textAlign = TextAlign.Center,
         color = MaterialTheme.colorScheme.onPrimary,
      )
   }
}

@Composable
fun PanelController(modifier: Modifier = Modifier){
   Box(
      modifier = modifier.fillMaxHeight()
         .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
         .padding(16.dp),
      contentAlignment = Alignment.Center

   ){
      Column (
         horizontalAlignment = Alignment.CenterHorizontally
      ){
         IconButton(onClick = {}) {
            Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Up")
         }
         Row {
            IconButton(onClick = { /* ← */ }) {
               Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Left")
            }
            Button (onClick = { /* Center */ }) {
               Text("○")
            }
            IconButton(onClick = { /* → */ }) {
               Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Right")
            }
         }
         IconButton(onClick = {}) {
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Down")
         }
      }
   }
}

@Composable
fun PanelMonitoring(modifier: Modifier = Modifier){
   val screenInfo = ScreenInfo()

   val textStyle = when (screenInfo.breakpoint){
      Breakpoint.Small -> MaterialTheme.typography.headlineSmall
      Breakpoint.Medium -> MaterialTheme.typography.headlineMedium
      Breakpoint.Large -> MaterialTheme.typography.headlineLarge
   }

   Column (
      modifier = modifier.fillMaxHeight()
         .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
         .padding(16.dp)
   ){
      Column(
         modifier = modifier.fillMaxSize()
            .padding(16.dp),
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Text(
            text = "Panel Monitoring",
            style = textStyle,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.padding(bottom = 16.dp)
         )

         Column (
            verticalArrangement = Arrangement.spacedBy(16.dp)
         ){
            Row (
               horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
               CardStat("Nozel 1 (L)", "000.00", Modifier.weight(1f))
               CardStat("Nozel 2 (L)", "000.00", Modifier.weight(1f))
            }
            Row (
               horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
               CardStat("Nozel 3 (L)", "000.00", Modifier.weight(1f))
               CardStat("Nozel 4 (L)", "000.00", Modifier.weight(1f))
            }
         }
      }
//      Card (
//         modifier = modifier.fillMaxWidth(),
//         shape = RoundedCornerShape(12.dp),
//         colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF2F5)),
//         elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//      ){
//
//      }
   }
}

@Composable
fun PanelPump(modifier: Modifier = Modifier){
   Card (
      modifier = modifier,
      shape = RoundedCornerShape(12.dp),
      elevation = CardDefaults.cardElevation(4.dp)
   ){
      Box(
         modifier = modifier.fillMaxWidth(),
         contentAlignment = Alignment.Center
      ){
         ButtonComponent(text = "Pump")
      }
   }
}