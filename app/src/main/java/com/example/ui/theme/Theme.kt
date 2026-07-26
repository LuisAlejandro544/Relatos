package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val RpgColorScheme = darkColorScheme(
  primary = GoldPrimary,
  onPrimary = Color(0xFF13100D),
  primaryContainer = Color(0xFF3D3219),
  onPrimaryContainer = GoldPrimary,
  secondary = CrimsonAccent,
  onSecondary = Color.White,
  secondaryContainer = Color(0xFF381414),
  onSecondaryContainer = Color(0xFFFFB4AB),
  tertiary = EmeraldAccent,
  onTertiary = Color.White,
  background = DarkBackground,
  onBackground = TextParchment,
  surface = DarkSurface,
  onSurface = TextParchment,
  surfaceVariant = DarkSurfaceVariant,
  onSurfaceVariant = TextMuted,
  outline = ParchmentBorder
)

@Composable
fun MyApplicationTheme(
  content: @Composable () -> Unit,
) {
  MaterialTheme(colorScheme = RpgColorScheme, typography = Typography, content = content)
}
