package com.nexin.yanopsbangan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nexin.yanopsbangan.utils.Breakpoint
import com.nexin.yanopsbangan.utils.ScreenInfo

@Composable
fun CardStat(title: String, value: String , modifier : Modifier = Modifier){
   val screenInfo = ScreenInfo()

   val textStyle = when (screenInfo.breakpoint){
      Breakpoint.Small -> MaterialTheme.typography.headlineSmall
      Breakpoint.Medium -> MaterialTheme.typography.headlineMedium
      Breakpoint.Large -> MaterialTheme.typography.headlineLarge
   }

   Card (
      modifier = modifier.height(150.dp),
      shape = RoundedCornerShape(8.dp),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
   ){
      Column (
         modifier = modifier.fillMaxSize()
            .background(Color.White)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
      ){
         Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
         )
         Text(
            text = value,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2E7D32)
         )
      }
   }
}