# 📁 ESTRUCTURA Y ARQUITECTURA DEL PROYECTO

Este documento detalla la estructura física de carpetas, la distribución de archivos fuente, los componentes de arquitectura y el flujo de datos de **Aethelgard RPG**.

---

## 🌳 Árbol Completo del Repositorio

```
/
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
        │   │   │   └── StoryEngine.kt   # Motor de historia, banco de escenas y elecciones
        │   │   ├── model/
        │   │   │   └── GameModel.kt     # Modelos de datos (GameState, CharacterClass, LogEntry, etc.)
        │   │   ├── ui/
        │   │   │   ├── GameScreen.kt    # Vistas en Jetpack Compose (Creación, Historia, HUD, Inventario)
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

## 🏛️ Responsabilidad de Capas (Arquitectura MVVM)

```
┌────────────────────────────────────────────────────────┐
│                   CAPA DE PRESENTACIÓN                 │
│  MainActivity.kt  ───>  GameScreen.kt (Composables)    │
└───────────────────────────┬────────────────────────────┘
                            │ (Observa StateFlow)
                            ▼
┌────────────────────────────────────────────────────────┐
│                    CAPA DE NEGOCIO                     │
│                  GameViewModel.kt                      │
└───────────────────────────┬────────────────────────────┘
                            │ (Aplica elecciones & estado)
                            ▼
┌────────────────────────────────────────────────────────┐
│                    CAPA DE DATOS                       │
│    GameModel.kt (Data Classes)  +  StoryEngine.kt      │
└────────────────────────────────────────────────────────┘
```

### 1. **Capa de Datos (`com.example.model` & `com.example.engine`)**
- **`GameModel.kt`**:
  - `CharacterClass`: Enum con clases, HP base, arma y armadura inicial.
  - `StoryChoice`: Representa una decisión con recompensas, cambios de HP u objetos.
  - `StoryScene`: Escena con plantilla narrativa y opciones.
  - `LogEntry`: Registro histórico para el diario de campaña.
  - `GameState`: Estado inmutable global del jugador.
- **`StoryEngine.kt`**:
  - Almacena el árbol de escenas del Prólogo y capítulos futuros.
  - Sustituye variables dinámicas (`{HERO_NAME}`, `{WEAPON}`, `{CLASS}`, `{ARMOR}`) en el texto.

### 2. **Capa de Dominio/ViewModel (`com.example.viewmodel`)**
- **`GameViewModel.kt`**:
  - Mantiene el `MutableStateFlow<GameState>`.
  - Procesa la creación de personaje y las decisiones elegidas por el usuario.
  - Calcula cambios de Vida (HP), Oro, Experiencia (EXP), subidas de Nivel y adición de objetos al inventario.

### 3. **Capa de Interfaz de Usuario (`com.example.ui`)**
- **`GameScreen.kt`**:
  - `CharacterCreationView`: Pantalla para seleccionar el nombre y la clase del héroe.
  - `MainGameStoryView`: Vista de lectura del pergamino, diario histórico y botones de opciones.
  - `HeroStatsHeader`: Barra superior con el nivel, HP, oro e inventario.
  - `InventoryDialog`: Diálogo flotante con las posesiones del jugador.
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
- **`Kotlin & Compose UI`**:
  - Se benefician del ecosistema Android nativo: reactividad con `StateFlow`, diseño adaptable M3, gestión de ciclo de vida del `ViewModel` y soporte fluido para animaciones de interfaz.
