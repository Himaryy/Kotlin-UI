package com.nexin.yanopsbangan.utils

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

enum class Breakpoint {
   Small, Medium, Large
}

enum class Orientation {
   Potrait, Landscape
}

data class ScreenSize(
   val breakpoint: Breakpoint,
   val orientation: Orientation,
   val screenWidthDp: Int,
   val screenHeightDp: Int,
)

@Composable
fun ScreenInfo(): ScreenSize{
   val config = LocalConfiguration.current

   val breakpoint = when {
      config.screenWidthDp < 600 -> Breakpoint.Small
      config.screenWidthDp < 900 -> Breakpoint.Medium
      else -> Breakpoint.Large
   }

   val orientation = if (config.orientation == Configuration.ORIENTATION_LANDSCAPE)
      Orientation.Landscape
   else
      Orientation.Potrait

   return ScreenSize(
      breakpoint = breakpoint,
      orientation = orientation,
      screenWidthDp = config.screenWidthDp,
      screenHeightDp = config.screenHeightDp
   )
}