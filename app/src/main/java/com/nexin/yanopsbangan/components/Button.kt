package com.nexin.yanopsbangan.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonComponent(text: String, modifier: Modifier = Modifier){
   Button(
      onClick = {},
      shape = RoundedCornerShape(10.dp),
      modifier = modifier.fillMaxWidth()
   ) {
      Text(
         text = text,
         style = MaterialTheme.typography.titleMedium
      )
   }
}