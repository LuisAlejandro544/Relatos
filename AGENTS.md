# 🤖 AGENTS.md - Reglas Persistentes del Proyecto

## Convenciones del Proyecto Aethelgard RPG

1. **Uso de Lenguaje y Tono Narrativo:**
   - Mantener el tono medieval sombrío realista.
   - El Guerrero Novato tiene 20 años y comenzó desde lo más bajo ("pelabola") trabajando en la taberna familiar.
   - Todos los cambios narrativos deben estar alineados con `/docs/BIBLIA_PERSONAJES.md`.

2. **Convenciones de Código Kotlin & Compose:**
   - Utilizar Jetpack Compose y Material Design 3.
   - Usar `StateFlow` en `GameViewModel` para comunicar estados a la UI.
   - Mantener inmutables las instancias de `GameState`.
   - Modificar las escenas narrativas en `StoryEngine.kt`.

3. **Verificación de Compilación:**
   - Ejecutar `compile_applet` tras realizar cambios significativos para asegurar la salud del build.
