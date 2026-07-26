package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.engine.StoryEngine
import com.example.model.GameState
import com.example.model.StoryChoice
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.GoldPrimary

@Composable
fun MainGameStoryView(
    state: GameState,
    onMakeChoice: (StoryChoice) -> Unit,
    onOpenInventory: () -> Unit
) {
    val listState = rememberLazyListState()

    // Scroll to bottom when new story entries are added
    LaunchedEffect(state.storyLog.size) {
        if (state.storyLog.isNotEmpty()) {
            listState.animateScrollToItem(state.storyLog.size)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Hero HUD Top Stats Bar
        HeroStatsHeader(state = state, onOpenInventory = onOpenInventory)

        // Story Log & Decisions Area
        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(state.storyLog) { entry ->
                StoryLogCard(entry = entry)
            }

            // Active Choices Card for Current Scene
            val currentScene = StoryEngine.getScene(state.currentSceneId)
            item {
                AnimatedVisibility(
                    visible = currentScene.choices.isNotEmpty(),
                    enter = fadeIn() + slideInVertically()
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = DarkSurface),
                        border = androidx.compose.foundation.BorderStroke(1.5.dp, GoldPrimary)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.AutoAwesome,
                                    contentDescription = null,
                                    tint = GoldPrimary,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "¿Qué decides hacer, ${state.heroName}?",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = GoldPrimary,
                                    fontFamily = FontFamily.Serif
                                )
                            }
                            Spacer(modifier = Modifier.height(12.dp))

                            currentScene.choices.forEach { choice ->
                                val formattedChoiceText = StoryEngine.formatNarrative(
                                    choice.text,
                                    state.heroName,
                                    state.characterClass
                                )
                                ChoiceButton(
                                    text = formattedChoiceText,
                                    onClick = { onMakeChoice(choice) }
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
