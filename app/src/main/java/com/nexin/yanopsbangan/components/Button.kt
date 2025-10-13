package com.nexin.yanopsbangan.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexin.yanopsbangan.R
import com.nexin.yanopsbangan.utils.MutedForeground
import com.nexin.yanopsbangan.utils.SuccessGreen
import com.nexin.yanopsbangan.utils.TextPrimary

@Composable
fun ButtonComponent(
   modifier: Modifier = Modifier,
   isActive: Boolean,
   onClick: ()-> Unit,
){

   val borderColor by animateColorAsState(
      if (isActive) Color.Transparent else MutedForeground
   )
   val backgroundColor by animateColorAsState(
      if (isActive) SuccessGreen else Color.Transparent
   )
   val textColor by animateColorAsState(
      if (isActive) TextPrimary else MutedForeground
   )


   Button(
      onClick = onClick,
      modifier = modifier
         .fillMaxWidth()
         .height(64.dp)
         .border(2.dp, borderColor, RoundedCornerShape(12.dp)),
      shape = RoundedCornerShape(12.dp),
      colors = ButtonDefaults.buttonColors(
         containerColor = backgroundColor,
         contentColor = textColor
      ),
      contentPadding = PaddingValues(vertical = 16.dp, horizontal = 40.dp)
   ) {
      Text(
         text = if (isActive) "PUMP ON" else "PUMP OFF",
         fontFamily = FontFamily(Font(R.font.jetbrains_bold)),
         fontSize = 20.sp
      )
   }
}