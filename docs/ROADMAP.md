# 🗺️ ROADMAP DE DESARROLLO - AETHELGARD RPG

---

### 🟢 FASE 1: Prólogo Jugable y Epílogo Ramificado (COMPLETADO)
- [x] Definición del concepto medieval sombrío y tono realista.
- [x] Arco inicial del Guerrero Novato (20 años, pelabola de taberna).
- [x] Implementación del Prólogo *"Cerveza, Sangre y Barro"* en `StoryEngine.kt`.
- [x] Expansión del **Epílogo Ramificado ("La Encrucijada de Oakhaven")** con 4 caminos principales y 8 sub-destinos (`/docs/EPILOGO.md`).
- [x] Integración de la arquitectura híbrida nativa `C++` & `Rust` vía `NativeEngineBridge.kt` para cálculo determinista de combate y ramificaciones.
- [x] Integración de NPCs principales: Garrick, Gideon y Brutus.
- [x] UI temática en Jetpack Compose con indicadores de HP, Oro, Nivel y Mochila.

---

### 🟡 FASE 2: Capítulo 1 - "Viviendo la Vida Dura" (EN PROCESO)
- [x] Diseño del borrador narrativo completo del **Capítulo 1: "Viviendo la Vida Dura"** (`/docs/CAPITULO_1_VIVIENDO_LA_VIDA_DURA.md`).
- [x] Definición del conflicto inicial 7 días después: la frialdad de Garrick y el entrenamiento callejero.
- [x] Introducción de los Cazarrecompensas (**Capitán Valerius "El Sabueso"**, **Kaelen "Dedos Fríos"** y **Dara "La Tuerta"**).
- [x] Definición de la presa: **Vance "Mano de Humo"** y la espada de acero robada.
- [ ] Implementación interactiva de las escenas del Capítulo 1 en `StoryEngine.kt`.
- [ ] Primera oportunidad de obtener una Espada Corta de Acero real o cobrar 40 monedas de plata.

---

### 🔵 FASE 3: Sistema de Combate Táctico e Inventario Avanzado
- [ ] Pantalla dedicada de Inventario con equipamiento visual (Arma, Armadura, Accesorio).
- [ ] Sistema de combate por turnos con habilidades especiales del Guerrero (*Embestida Voraz*, *Postura Defensiva*).
- [ ] Sistema de Tiradas de Dados / Chequeos de Habilidad (Fuerza, Astucia, Carisma).

---

### 🟣 FASE 4: Expansión de Clases y Persistencia
- [ ] Arco narrativo del **Mago Arcano** (Aprendiz expulsado de la Academia).
- [ ] Arco narrativo del **Pícaro** (Ladrón de poca monta en los suburbios).
- [ ] Integración completa con Room Database para guardado de partidas múltiples.
