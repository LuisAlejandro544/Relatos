# 🤖 AI_CONTEXT.md - GUÍA PARA AGENTES Y MODELOS DE IA

Este archivo sirva como instrucción guía para cualquier modelo de Inteligencia Artificial (Gemini, Claude, GPT, etc.) que trabaje en este repositorio.

---

### 📌 1. FILOSOFÍA Y TONO DEL JUEGO
- **Temática:** Juego de rol medieval sombrío (*Dark Fantasy / Grounded Fantasy*).
- **Enfoque del Protagonista:** El Guerrero no es un príncipe ni un elegido profético; es un joven de 20 años que trabajó toda su vida en una taberna y empieza desde la absoluta miseria ("pelabola").
- **Tono Narrativo:** Maduro, humano, con toques de humor realista en los diálogos pero sin caer en parodia.
- **Consultar siempre:** Antes de escribir código narrativo o nuevos personajes, revisa `/docs/BIBLIA_PERSONAJES.md` y `/docs/HISTORIA_Y_CAPITULOS.md`.

---

### 🧱 2. ARQUITECTURA DEL CÓDIGO
- **`com.example.model.GameModel`**:
  - `CharacterClass`: Enum con las clases y su equipamiento base.
  - `GameState`: Data class inmutable que guarda el estado de la partida (`currentHp`, `gold`, `currentSceneId`, `inventory`).
- **`com.example.engine.StoryEngine`**:
  - Contiene el mapa de escenas `StoryScene` y elecciones `StoryChoice`.
  - Reemplaza marcadores dinámicos como `{HERO_NAME}`, `{WEAPON}`, `{CLASS}` y `{ARMOR}`.
- **`com.example.viewmodel.GameViewModel`**:
  - Expone `StateFlow<GameState>` para la UI en Compose.
  - Maneja la navegación entre escenas y el procesamiento de recompensas/daño.
- **`com.example.ui.GameScreen`**:
  - Composable principal con interfaz pergamino M3, barras de vida, opciones interactivas y registro de bitácora.

---

### 🎨 3. REGLAS ESTRICTAS DE UI / DISEÑO
- Usar **Jetpack Compose** exclusivamente con **Material Design 3**.
- Mantener la paleta medieval (`ParchmentBg`, `DarkSurface`, `CrimsonAccent`, `GoldAccent`).
- **NUNCA** usar colores neón ni estilos futuristas/cyberpunk.
- Todos los componentes interactivos deben tener `testTag` para pruebas.
