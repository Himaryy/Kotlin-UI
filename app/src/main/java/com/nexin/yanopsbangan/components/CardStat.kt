package com.nexin.yanopsbangan.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexin.yanopsbangan.R
import com.nexin.yanopsbangan.utils.ArmyOlive
import com.nexin.yanopsbangan.utils.Breakpoint
import com.nexin.yanopsbangan.utils.CardSurface
import com.nexin.yanopsbangan.utils.ScreenInfo
import com.nexin.yanopsbangan.utils.SuccessGreen
import com.nexin.yanopsbangan.utils.TextSecondary

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
      colors = CardDefaults.cardColors(containerColor = CardSurface),
      border = BorderStroke(1.dp, ArmyOlive)
   ){
      Row (
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center,
         modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
      ){
         Image(
            painter = painterResource(R.drawable.gas_station),
            contentDescription = "Nozzle Logo",
            modifier = Modifier
               .size(64.dp),
            colorFilter = ColorFilter.tint(ArmyOlive)
         )

         Spacer(modifier = Modifier.width(16.dp))

         Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
         ){
            Text(
               text = title,
               color = TextSecondary,
               fontFamily = FontFamily(
                  Font(R.font.jetbrains_medium)
               )
            )
            Text(
               text = value,
               color = SuccessGreen,
               fontFamily = FontFamily(
                  Font(R.font.jetbrains_bold)
               ),
               fontSize = 24.sp
            )
         }
      }
   }
}