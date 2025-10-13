package com.nexin.yanopsbangan.pages

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexin.yanopsbangan.R
import com.nexin.yanopsbangan.components.ButtonComponent
import com.nexin.yanopsbangan.components.CardStat
import com.nexin.yanopsbangan.utils.ArmyGreen
import com.nexin.yanopsbangan.utils.ArmyOlive
import com.nexin.yanopsbangan.utils.BackgroundDark
import com.nexin.yanopsbangan.utils.Breakpoint
import com.nexin.yanopsbangan.utils.CardSurface
import com.nexin.yanopsbangan.utils.HighlightYellow
import com.nexin.yanopsbangan.utils.MutedForeground
import com.nexin.yanopsbangan.utils.ScreenInfo
import com.nexin.yanopsbangan.utils.SuccessGreen
import com.nexin.yanopsbangan.utils.TextPrimary

@Composable
fun Homepage(modifier: Modifier = Modifier){
   var isPumpActive by remember { mutableStateOf(false) }

   Column(
      modifier.fillMaxSize()
         .background(BackgroundDark)

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

         // Pump Button and Status
        Column (
           modifier = Modifier
              .weight(1f)          // column width in the Row
              .fillMaxHeight(),    // ⬅️ match height of other panels
           verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
           ButtonComponent(
              modifier = Modifier
                 .fillMaxWidth(),
              isActive = isPumpActive,
              onClick = {
                 isPumpActive = !isPumpActive
              }
           )

           //Status
           CardStatus(modifier = Modifier.weight(1f))
        }
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
         .background(ArmyGreen),
      contentAlignment = Alignment.Center
   ){
      Row (
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center
      ){
         Image(
            painter = painterResource(id = R.drawable.logo_puspenerbad),
            contentDescription = "Logo",
            modifier = Modifier
               .size(124.dp) // ubah sesuai proporsi
               .padding(end = 16.dp)
         )

         Text(
            text = "PUSPENERBAD AD",
            fontFamily = FontFamily(
               Font(R.font.poppins_bold)
            ),
            textAlign = TextAlign.Center,
            color = HighlightYellow,
            fontSize = 64.sp
         )
      }
   }
}

@Composable
fun PanelController(modifier: Modifier = Modifier) {
   val btnSize = 96.dp        // 🔹 tombol lebih besar
   val iconSize = 92.dp       // 🔹 ikon lebih besar (proporsional)
   val centerSize = 96.dp
   val arrowPadding = 20.dp    // 🔹 jarak antar tombol

   Box(
      modifier = modifier
         .fillMaxHeight()
         .border(2.dp, ArmyOlive, RoundedCornerShape(8.dp))
         .background(CardSurface, shape = RoundedCornerShape(8.dp))
         .padding(16.dp),
      contentAlignment = Alignment.Center
   ) {
      Column(
         modifier = modifier.fillMaxSize()
            .padding(16.dp),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
      ) {
         Text(
            text = "Crane Control",
            fontFamily = FontFamily(
               Font(R.font.poppins_semibold)
            ),
            color = HighlightYellow,
            modifier = Modifier.padding(bottom = 24.dp),
            fontSize = 28.sp
         )

         // Controller
         Box(
            contentAlignment = Alignment.Center,
            modifier= modifier.weight(1f)
               .offset(y = (-45).dp)
         ) {
            // Center Button
            Button(
               onClick = { /* center */ },
               modifier = Modifier.size(centerSize).padding(12.dp),
               shape = CircleShape,
               border = BorderStroke(2.dp, MutedForeground,),
               colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
               elevation = ButtonDefaults.buttonElevation(0.dp)
            ) {
               Text("○", color = MutedForeground)
            }

            // Up
            FilledIconButton (
               onClick = { /* ↑ */ },
               modifier = Modifier
                  .size(btnSize)
                  .offset(y = (-centerSize / 1.5f - arrowPadding)),
               shape = RoundedCornerShape(8.dp),
               colors = IconButtonDefaults.filledIconButtonColors(
                  containerColor = Color.Transparent,
                  contentColor = SuccessGreen
               )
            ) {
               Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Up", modifier = Modifier.size(iconSize))
            }

            // Down
            FilledIconButton(
               onClick = { /* ↓ */ },
               modifier = Modifier
                  .size(btnSize)
                  .offset(y = (centerSize / 1.5f + arrowPadding)),
               shape = RoundedCornerShape(8.dp),
               colors = IconButtonDefaults.filledIconButtonColors(
                  containerColor = Color.Transparent,
                  contentColor = SuccessGreen
               )
            ) {
               Icon(
                  Icons.Default.KeyboardArrowDown,
                  contentDescription = "Down",
                  modifier = Modifier.size(iconSize)

               )
            }

            // Left
            FilledIconButton(
               onClick = { /* ← */ },
               modifier = Modifier
                  .size(btnSize)
                  .offset(x = (-centerSize / 1.5f - arrowPadding)),
               shape = RoundedCornerShape(8.dp),
               colors = IconButtonDefaults.filledIconButtonColors(
                  containerColor = Color.Transparent,
                  contentColor = SuccessGreen
               )
            ) {
               Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Left", modifier = Modifier.size(iconSize))
            }

            // Right
            FilledIconButton(
               onClick = { /* → */ },
               modifier = Modifier
                  .size(btnSize)
                  .offset(x = (centerSize / 1.5f + arrowPadding)),
               shape = RoundedCornerShape(8.dp),
               colors = IconButtonDefaults.filledIconButtonColors(
                  containerColor = Color.Transparent,
                  contentColor = SuccessGreen
               )
            ) {
               Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Right", modifier = Modifier.size(iconSize))
            }
         }
      }
   }
}


@Composable
fun PanelMonitoring(modifier: Modifier = Modifier) {
   val screenInfo = ScreenInfo()

   val textStyle = when (screenInfo.breakpoint){
      Breakpoint.Small -> MaterialTheme.typography.headlineSmall
      Breakpoint.Medium -> MaterialTheme.typography.headlineMedium
      Breakpoint.Large -> MaterialTheme.typography.headlineLarge
   }

   Column (
      modifier = modifier.fillMaxHeight()
         .border(2.dp, ArmyOlive, RoundedCornerShape(8.dp))
         .background(CardSurface, shape = RoundedCornerShape(8.dp))
         .padding(16.dp)
   ){
      Column(
         modifier = modifier.fillMaxSize()
            .padding(16.dp),
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Text(
            text = "Panel Monitoring",
            fontFamily = FontFamily(
               Font(R.font.poppins_semibold)
            ),
            color = HighlightYellow,
            modifier = Modifier.padding(bottom = 24.dp),
            fontSize = 28.sp
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
   }
}

@Composable
fun CardStatus(
   modifier: Modifier = Modifier
){
   Card(
      modifier = modifier
         .fillMaxWidth()
         .border(2.dp, ArmyOlive, RoundedCornerShape(8.dp))
         .background(CardSurface, shape = RoundedCornerShape(8.dp)),
      colors = CardDefaults.cardColors(containerColor = Color.Transparent)

   ) {
      Text(
         text = "Status",
         modifier = Modifier.padding(16.dp),
         fontFamily = FontFamily(
            Font(R.font.poppins_semibold)),
         fontSize = 20.sp,
         color = HighlightYellow
      )
   }
}