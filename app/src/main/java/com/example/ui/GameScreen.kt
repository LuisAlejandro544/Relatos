package com.example.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.engine.StoryEngine
import com.example.model.CharacterClass
import com.example.model.GameState
import com.example.model.LogEntry
import com.example.ui.theme.CrimsonAccent
import com.example.ui.theme.DarkBackground
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.EmeraldAccent
import com.example.ui.theme.GoldPrimary
import com.example.ui.theme.ParchmentBorder
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextParchment
import com.example.viewmodel.GameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    viewModel: GameViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.uiState.collectAsState()
    var showInventoryDialog by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = DarkBackground,
        topBar = {
            if (state.isGameStarted) {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = DarkSurface,
                        titleContentColor = GoldPrimary
                    ),
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Shield,
                                contentDescription = null,
                                tint = GoldPrimary,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Aethelgard RPG",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { showInventoryDialog = true },
                            modifier = Modifier.testTag("inventory_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Inventory2,
                                contentDescription = "Inventario",
                                tint = GoldPrimary
                            )
                        }
                        IconButton(
                            onClick = { viewModel.resetGame() },
                            modifier = Modifier.testTag("reset_game_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Reiniciar juego",
                                tint = TextMuted
                            )
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (!state.isGameStarted) {
                CharacterCreationView(
                    state = state,
                    onNameChanged = viewModel::updateHeroName,
                    onClassSelected = viewModel::selectClass,
                    onStartGame = viewModel::startGame
                )
            } else {
                MainGameStoryView(
                    state = state,
                    onMakeChoice = viewModel::makeChoice,
                    onOpenInventory = { showInventoryDialog = true }
                )
            }
        }
    }

    if (showInventoryDialog) {
        InventoryDialog(
            state = state,
            onDismiss = { showInventoryDialog = false }
        )
    }
}

@Composable
fun CharacterCreationView(
    state: GameState,
    onNameChanged: (String) -> Unit,
    onClassSelected: (CharacterClass) -> Unit,
    onStartGame: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            // Hero Banner Header
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                shape = RoundedCornerShape(16.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, ParchmentBorder)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.img_story_banner_1785013133738),
                        contentDescription = "Fondo de Aethelgard",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        DarkBackground.copy(alpha = 0.85f),
                                        DarkBackground
                                    )
                                )
                            )
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "RELATOS DE AETHELGARD",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldPrimary,
                            fontFamily = FontFamily.Serif
                        )
                        Text(
                            text = "Aventura y decisiones basadas en texto",
                            fontSize = 13.sp,
                            color = TextMuted
                        )
                    }
                }
            }
        }

        item {
            // Character Name Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = DarkSurface),
                border = androidx.compose.foundation.BorderStroke(1.dp, ParchmentBorder)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = GoldPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "1. Nombre de tu Héroe",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextParchment
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = state.heroName,
                        onValueChange = onNameChanged,
                        placeholder = { Text("Escribe tu nombre...", color = TextMuted) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("hero_name_input"),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = GoldPrimary,
                            unfocusedBorderColor = ParchmentBorder,
                            focusedTextColor = TextParchment,
                            unfocusedTextColor = TextParchment,
                            focusedContainerColor = DarkSurfaceVariant,
                            unfocusedContainerColor = DarkSurfaceVariant
                        ),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
                    )
                }
            }
        }

        item {
            // Class Selection Header
            Text(
                text = "2. Selecciona tu Clase de Combate",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextParchment,
                modifier = Modifier.padding(start = 4.dp, top = 4.dp)
            )
        }

        items(CharacterClass.values()) { cls ->
            val isSelected = state.characterClass == cls
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onClassSelected(cls) }
                    .testTag("class_card_${cls.name}"),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) DarkSurfaceVariant else DarkSurface
                ),
                border = androidx.compose.foundation.BorderStroke(
                    width = if (isSelected) 2.dp else 1.dp,
                    color = if (isSelected) GoldPrimary else ParchmentBorder
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = cls.iconEmoji,
                        fontSize = 28.sp,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = cls.title,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) GoldPrimary else TextParchment
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = CrimsonAccent.copy(alpha = 0.2f),
                                border = androidx.compose.foundation.BorderStroke(1.dp, CrimsonAccent)
                            ) {
                                Text(
                                    text = "${cls.baseHp} HP",
                                    fontSize = 11.sp,
                                    color = Color(0xFFFF8A8A),
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = cls.description,
                            fontSize = 12.sp,
                            color = TextMuted
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Arma: ${cls.weaponName} | Armadura: ${cls.armorName}",
                            fontSize = 11.sp,
                            color = GoldPrimary.copy(alpha = 0.8f)
                        )
                    }
                    if (isSelected) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Seleccionado",
                            tint = GoldPrimary,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onStartGame,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .testTag("start_game_button"),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GoldPrimary,
                    contentColor = DarkBackground
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "ENTRAR AL REINO",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun MainGameStoryView(
    state: GameState,
    onMakeChoice: (com.example.model.StoryChoice) -> Unit,
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

@Composable
fun HeroStatsHeader(
    state: GameState,
    onOpenInventory: () -> Unit
) {
    Surface(
        color = DarkSurface,
        border = androidx.compose.foundation.BorderStroke(1.dp, ParchmentBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Name & Class
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = state.characterClass.iconEmoji,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(end = 6.dp)
                    )
                    Column {
                        Text(
                            text = state.heroName,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextParchment
                        )
                        Text(
                            text = "${state.characterClass.title} (Niv. ${state.level})",
                            fontSize = 11.sp,
                            color = GoldPrimary
                        )
                    }
                }

                // Gold & Inventory Quick Access
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Gold Pill
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = DarkSurfaceVariant,
                        border = androidx.compose.foundation.BorderStroke(1.dp, ParchmentBorder)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.MonetizationOn,
                                contentDescription = "Oro",
                                tint = GoldPrimary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${state.gold}",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = GoldPrimary
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Inventory Pill
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = DarkSurfaceVariant,
                        border = androidx.compose.foundation.BorderStroke(1.dp, ParchmentBorder),
                        modifier = Modifier.clickable { onOpenInventory() }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Inventory2,
                                contentDescription = "Inventario",
                                tint = TextParchment,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${state.inventory.size}",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextParchment
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Health Bar
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Vida",
                    tint = CrimsonAccent,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                val hpRatio = state.currentHp.toFloat() / state.maxHp.toFloat()
                LinearProgressIndicator(
                    progress = { hpRatio.coerceIn(0f, 1f) },
                    modifier = Modifier
                        .weight(1f)
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = CrimsonAccent,
                    trackColor = CrimsonAccent.copy(alpha = 0.2f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${state.currentHp}/${state.maxHp} HP",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextParchment
                )
            }
        }
    }
}

@Composable
fun StoryLogCard(entry: LogEntry) {
    if (entry.isSystemNotice) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = EmeraldAccent.copy(alpha = 0.15f)),
            border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldAccent)
        ) {
            Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = EmeraldAccent,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = entry.title,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = EmeraldAccent
                    )
                    Text(
                        text = entry.text,
                        fontSize = 12.sp,
                        color = TextParchment
                    )
                }
            }
        }
    } else {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Previous Choice Badge if present
            entry.choiceMadeText?.let { choiceText ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 6.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = DarkSurfaceVariant,
                        border = androidx.compose.foundation.BorderStroke(1.dp, ParchmentBorder)
                    ) {
                        Text(
                            text = "Acción: $choiceText",
                            fontSize = 12.sp,
                            color = GoldPrimary,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                        )
                    }
                }
            }

            // Story Scene Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = DarkSurface),
                border = androidx.compose.foundation.BorderStroke(1.dp, ParchmentBorder)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = entry.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldPrimary,
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = entry.text,
                        fontSize = 14.sp,
                        lineHeight = 22.sp,
                        color = TextParchment
                    )
                }
            }
        }
    }
}

@Composable
fun ChoiceButton(
    text: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .testTag("choice_button_${text.take(10)}"),
        color = DarkSurfaceVariant,
        border = androidx.compose.foundation.BorderStroke(1.dp, ParchmentBorder)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = TextParchment,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = GoldPrimary,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InventoryDialog(
    state: GameState,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = DarkSurface,
        titleContentColor = GoldPrimary,
        textContentColor = TextParchment,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Inventory2,
                    contentDescription = null,
                    tint = GoldPrimary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Mochila de ${state.heroName}",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Oro: ${state.gold} monedas de la corona",
                    color = GoldPrimary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Objetos y Equipo Actual:",
                    fontSize = 13.sp,
                    color = TextMuted
                )
                Spacer(modifier = Modifier.height(8.dp))

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    state.inventory.forEach { item ->
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = DarkSurfaceVariant,
                            border = androidx.compose.foundation.BorderStroke(1.dp, ParchmentBorder)
                        ) {
                            Text(
                                text = "⚔️ $item",
                                fontSize = 12.sp,
                                color = TextParchment,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Cerrar", color = GoldPrimary)
            }
        }
    )
}
