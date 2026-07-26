# 📁 ESTRUCTURA Y ARQUITECTURA DEL PROYECTO

Este documento detalla la estructura física de carpetas, la distribución de archivos fuente, los componentes de arquitectura y el flujo de datos de **Aethelgard RPG**.

---

## 🌳 Árbol Completo del Repositorio

```
/
├── .github/
│   └── workflows/
│       └── android-build.yml            # CI/CD: Compilación de APK Debug y generación de firma en caliente
├── .env.example                         # Plantilla de variables de entorno (p. ej. claves de API)
├── .gitignore                           # Archivos ignorados por Git
├── AGENTS.md                            # Reglas persistentes y convenciones para agentes de IA
├── README.md                            # Presentación e instrucciones generales del proyecto
├── metadata.json                        # Identidad de la aplicación en AI Studio
├── build.gradle.kts                     # Gradle raíz con plugins globales
├── settings.gradle.kts                  # Configuración del proyecto Gradle
├── gradle.properties                    # Propiedades de compilación de Gradle
├── gradle/
│   └── libs.versions.toml               # Catálogo de versiones de dependencias (TOML)
├── docs/                                # Documentación técnica y narrativa
│   ├── AI_CONTEXT.md                    # Guía técnica y filosofía de código para modelos de IA
│   ├── BIBLIA_PERSONAJES.md              # Registro de personajes, trasfondos y personalidades
│   ├── EPILOGO.md                       # Documentación del epílogo ramificado y árbol de decisiones
│   ├── ESTRUCTURA.md                    # (Este archivo) Mapa y arquitectura de código
│   ├── HISTORIA_Y_CAPITULOS.md          # Planificación de arcos narrativos y escenas
│   └── ROADMAP.md                       # Hoja de ruta del desarrollo del juego
├── native/                              # Módulo nativo en Rust
│   └── rust_core/
│       ├── Cargo.toml                   # Configuración del paquete Cargo y dependencias Rust
│       └── src/
│           └── lib.rs                   # Implementación del motor determinista en Rust
└── app/                                 # Módulo principal de la aplicación Android
    ├── build.gradle.kts                 # Configuración de dependencias y Android SDK del módulo app
    ├── proguard-rules.pro               # Reglas de ofuscación de código
    └── src/
        ├── main/
        │   ├── AndroidManifest.xml      # Manifiesto de Android con permisos y Activity principal
        │   ├── cpp/
        │   │   ├── CMakeLists.txt       # Guía de compilación NDK CMake para C++20
        │   │   └── aethelgard_native.cpp # Implementación nativa JNI de cálculo de combate
        │   ├── java/com/example/
        │   │   ├── MainActivity.kt      # Punto de entrada de la app en Kotlin (SetContent)
        │   │   ├── engine/
        │   │   │   ├── NativeEngineBridge.kt # Puente JNI para motor de lógica nativa C++ & Rust
        │   │   │   ├── StoryEngine.kt   # Motor principal de narrativa y orquestación de escenas
        │   │   │   └── scenes/          # Módulos de contenido narrativo por arcos/capítulos
        │   │   │       ├── PrologueScenes.kt # Escenas del Prólogo ("Cerveza, Sangre y Barro")
        │   │   │       ├── EpilogueScenes.kt # Escenas del Epílogo ramificado (4 caminos)
        │   │   │       └── Chapter1Scenes.kt # Escenas del Capítulo 1 ("Viviendo la Vida Dura")
        │   │   ├── model/               # Modelos de datos modularizados
        │   │   │   ├── CharacterClass.kt # Enum con clases de personajes y estadísticas base
        │   │   │   ├── StoryChoice.kt   # Data class para opciones y recompensas
        │   │   │   ├── StoryScene.kt    # Data class para escenas y plantillas narrativas
        │   │   │   ├── LogEntry.kt      # Data class para el diario de campaña
        │   │   │   └── GameState.kt     # Data class del estado global inmutable del jugador
        │   │   ├── ui/
        │   │   │   ├── GameScreen.kt    # Contenedor principal de la interfaz y Scaffold
        │   │   │   ├── components/      # Componentes modulares de Compose UI
        │   │   │   │   ├── CharacterCreationView.kt # Pantalla de creación y selección de héroe
        │   │   │   │   ├── MainGameStoryView.kt     # Lectura del diario, pergamino y decisiones
        │   │   │   │   ├── HeroStatsHeader.kt       # Barra superior de HUD (HP, Oro, Clase, Nivel)
        │   │   │   │   ├── StoryLogCard.kt          # Tarjetas narrativas e historial
        │   │   │   │   ├── ChoiceButton.kt          # Botones interactivos de toma de decisiones
        │   │   │   │   └── InventoryDialog.kt       # Diálogo modal de mochila e inventario
        │   │   │   └── theme/
        │   │   │       ├── Color.kt     # Paleta de colores medieval (Oro, Pergamino, Carmesí)
        │   │   │       ├── Theme.kt     # Tema M3 personalizado para el juego
        │   │   │       └── Type.kt      # Estilos de tipografía
        │   │   └── viewmodel/
        │   │       └── GameViewModel.kt # ViewModel principal con gestión de estado via StateFlow
        │   └── res/
        │       ├── drawable/            # Imágenes, íconos y banners del juego
        │       ├── mipmap-*/            # Íconos adaptativos del launcher
        │       └── values/              # strings.xml, colors.xml y themes.xml
        └── test/                        # Pruebas unitarias en JVM local con Robolectric y Roborazzi
```

---

## 🏛️ Responsabilidad de Capas (Arquitectura MVVM Modular)

```
┌──────────────────────────────────────────────────────────────────────────────────┐
│                             CAPA DE PRESENTACIÓN                                 │
│ MainActivity.kt ─> GameScreen.kt ─> ui/components/* (Componentes Reutilizables) │
└────────────────────────────────────────┬─────────────────────────────────────────┘
                                         │ (Observa StateFlow)
                                         ▼
┌──────────────────────────────────────────────────────────────────────────────────┐
│                              CAPA DE NEGOCIO                                     │
│                            GameViewModel.kt                                      │
└────────────────────────────────────────┬─────────────────────────────────────────┘
                                         │ (Aplica elecciones & estado)
                                         ▼
┌──────────────────────────────────────────────────────────────────────────────────┐
│                               CAPA DE DATOS                                      │
│   com.example.model/* (Classes) + StoryEngine.kt (Orquestador) + engine/scenes/*  │
└──────────────────────────────────────────────────────────────────────────────────┘
```

### 1. **Capa de Datos Modularizada (`com.example.model` & `com.example.engine`)**
- **`com.example.model`**:
  - `CharacterClass.kt`: Enum con clases, HP base, arma y armadura inicial.
  - `StoryChoice.kt`: Representa una decisión con recompensas, cambios de HP u objetos.
  - `StoryScene.kt`: Escena con plantilla narrativa y opciones.
  - `LogEntry.kt`: Registro histórico para el diario de campaña.
  - `GameState.kt`: Estado inmutable global del jugador.
- **`com.example.engine` & `com.example.engine.scenes`**:
  - `StoryEngine.kt`: Orquestador principal de narrativa que combina módulos de escenas y sustituye variables dinámicas (`{HERO_NAME}`, `{WEAPON}`, `{CLASS}`, `{ARMOR}`).
  - `PrologueScenes.kt`: Contiene el banco completo de escenas del Prólogo en la taberna.
  - `EpilogueScenes.kt`: Contiene la encrucijada y los 4 caminos del Epílogo ramificado.
  - `Chapter1Scenes.kt`: Contiene la trama completa del Capítulo 1 con los cazarrecompensas.

### 2. **Capa de Dominio/ViewModel (`com.example.viewmodel`)**
- **`GameViewModel.kt`**:
  - Mantiene el `MutableStateFlow<GameState>`.
  - Procesa la creación de personaje y las decisiones elegidas por el usuario.
  - Calcula cambios de Vida (HP), Oro, Experiencia (EXP), subidas de Nivel y adición de objetos al inventario.

### 3. **Capa de Interfaz de Usuario Modularizada (`com.example.ui`)**
- **`GameScreen.kt`**: Contenedor Scaffold de alto nivel con TopBar y diálogo de inventario.
- **`com.example.ui.components`**:
  - `CharacterCreationView.kt`: Vista dedicada a la selección de nombre y clase del héroe.
  - `MainGameStoryView.kt`: Vista de lectura del pergamino, diario histórico y opciones activas.
  - `HeroStatsHeader.kt`: Barra superior HUD con nivel, HP, oro e inventario.
  - `StoryLogCard.kt`: Tarjetas de narrativa e historial de decisiones.
  - `ChoiceButton.kt`: Botones de acción estilizados con M3.
  - `InventoryDialog.kt`: Diálogo flotante modal con el contenido de la mochila del personaje.
- **`Theme.kt` & `Color.kt`**:
  - Define la paleta medieval de Material Design 3.

---

### 4. **Capa de Lógica Nativa Híbrida (`C++`, `Rust` & `Kotlin`)**
- **`Rust Logic Core`**:
  - Verificación determinista de semillas RNG y matrices de ramificación inmutables.
  - Cero costo de abstracción, seguridad de memoria sin recolector de basura y validación del estado del juego.
- **`C++ Performance Engine`**:
  - Cálculo de simulaciones de combate, fórmulas de daño y mitigación en tiempo real vía JNI.
- **`NativeEngineBridge.kt`**:
  - Puente JNI en Kotlin que conecta las llamadas de la capa de dominio/ViewModel con los métodos nativos exportados por Rust/C++.
