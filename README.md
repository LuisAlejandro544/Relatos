# 🗡️ AETHELGARD RPG: Relatos de Sombra y Acero

**Aethelgard RPG** es un juego de rol narrativo e interactivo medieval desarrollado con **Kotlin** y **Jetpack Compose** para Android. El jugador asume el rol de un joven de 20 años que inicia su camino como Guerrero desde la absoluta miseria ("pelabola") tras rebelarse del destino impuesto por su padre en una taberna familiar.

---

## 🌟 Características Principales

- 📜 **Narrativa Ramificada por Capítulos:** Toman decisiones con consecuencias permanentes en la historia, reputación y desarrollo de personajes.
- 🛡️ **Arco del Guerrero Novato:** Experimenta la progresión desde una espada de madera y trapos hasta convertirte en una leyenda de Aethelgard.
- 👥 **Sistema de NPCs Dinámico:** Interactúa con personajes memorables como Garrick el tabernero, Gideon el veterano borrachín y Brutus el recaudador.
- 🎨 **Interfaz Temática Medieval (M3):** Diseño adaptativo con paleta de colores de pergamino, oro viejo, cuero y obsidiana.
- 🎒 **Sistema de Inventario y Progreso:** Control de Vida (HP), Monedas de Cobre/Oro, Experiencia (EXP) e Inventario activo.

---

## 🛠️ Stack Tecnológico

- **Lenguaje:** Kotlin
- **UI Framework:** Jetpack Compose (Material Design 3)
- **Arquitectura:** MVVM (Model-View-ViewModel) + StateFlow
- **Motor Narrativo:** `StoryEngine` personalizado con plantillas dinámicas
- **Persistencia:** Room Database (preparado) & M3 Design System

---

## 📂 Estructura del Proyecto

```
/
├── app/
│   └── src/main/java/com/example/
│       ├── engine/         # Motor de historia y lógica de elecciones (StoryEngine.kt)
│       ├── model/          # Modelos de datos (GameState, CharacterClass, StoryScene)
│       ├── ui/             # Composables de UI (GameScreen.kt, Theme.kt, Color.kt)
│       └── viewmodel/      # ViewModel de Compose (GameViewModel.kt)
├── docs/
│   ├── BIBLIA_PERSONAJES.md  # Registro detallado de personajes y lore
│   ├── ESTRUCTURA.md         # Mapa completo de carpetas y arquitectura de código
│   ├── HISTORIA_Y_CAPITULOS.md# Planificación de actos y capítulos
│   ├── ROADMAP.md            # Hoja de ruta de desarrollo
│   └── AI_CONTEXT.md         # Guía de contexto para asistentes de IA
├── AGENTS.md                 # Reglas y convenciones del repositorio
└── README.md
```
