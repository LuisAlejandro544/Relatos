# 📜 AETHELGARD RPG: EPÍLOGO RAMIFICADO
## "La Encrucijada de Oakhaven"

---

### 🗡️ 1. Visión General del Epílogo
El Epílogo marca el clímax dramático del Prólogo **"Cerveza, Sangre y Barro"**. Tras la caída de **Brutus 'El Recaudador'** en las tablas de la taberna *'La Jarra Mellada'*, el destino del joven Guerrero Novato de 20 años deja de ser el de un simple criado o "pelabola" para convertirse en la fuerza que moldeará el futuro de Oakhaven.

El Epílogo presenta un sistema de **4 Ramas Principales** y **8 Sub-Destinos** interconectados deterministamente.

---

### 🗺️ 2. Árbol de Decisiones y Ramificaciones

```
                      [DERROTA DE BRUTUS EN 'LA JARRA MELLADA']
                                        │
                                        ▼
                   [SCENE_EPILOGUE_BRANCH_HUB: La Encrucijada]
                                        │
    ┌───────────────────┬───────────────┴───────────────┬───────────────────┐
    ▼                   ▼                               ▼                   ▼
[RAMA I: GUARDIÁN]  [RAMA II: MERCENARIO]     [RAMA III: PROSCRITO]    [RAMA IV: SOMBRAS]
 (Defensa Local)     (Lobos de Hierro)         (Bosque de Brumas)       (Contrabando)
    │                   │                               │                   │
 ┌──┴──┐             ┌──┴──┐                         ┌──┴──┐             ┌──┴──┐
 ▼     ▼             ▼     ▼                         ▼     ▼             ▼     ▼
[I.1] [I.2]        [II.1] [II.2]                   [III.1][III.2]       [IV.1][IV.2]
```

---

### 📜 3. Desglose Narrativo por Ramas

#### **🛡️ RAMA I: El Guardián de Oakhaven (Camino del Honor Local)**
- **Detonante:** Te niegas a abandonar a tu padre **Garrick** y a los aldeanos indefensos frente a la inevitable venganza del Feudo.
- **Sub-destinos:**
  - **I.1 (Capitán de la Milicia):** Armas a 30 campesinos con horcas y hachas. Te conviertes en el Comandante de la Milicia Campesina de Oakhaven.
  - **I.2 (La Fortaleza de la Taberna):** Fortificas *'La Jarra Mellada'* con vigas de roble reforzadas, transformando la taberna familiar en un fortín inexpugnable.
- **Consecuencia:** Tu padre Garrick te entrega el escudo de su juventud con orgullo. Ganas reputación heroica comunal.

#### **⚔️ RAMA II: La Compañía de los Lobos de Hierro (Camino Mercenario)**
- **Detonante:** Aceptas la recomendación sellada en cera roja de **Gideon 'El Tuerto'** para unirte a su antigua tropa de élite.
- **Sub-destinos:**
  - **II.1 (Espada a Sueldo):** Te enrolas en la vanguardia de la infantería pesada del Capitán Vane.
  - **II.2 (Cabo de Vanguardia):** Derrotas en un brutal duelo al sargento reclutador, obteniendo mando inmediato sobre una escuadra de mercenarios.
- **Consecuencia:** Abandonas Oakhaven rumbo a las Tierras Bajas. Inicias el Capítulo 1 con armamento pesado y oro a sueldo.

#### **🌲 RAMA III: El Proscrito del Bosque de las Brumas (Camino Rebelde)**
- **Detonante:** Saqueas las 50 monedas de plata del cofre de Brutus junto al libro de contabilidad de extorsiones y huyes en la noche.
- **Sub-destinos:**
  - **III.1 (La Sombra Justiciera):** Repartes el tributo robado entre los siervos arruinados de Oakhaven, convirtiéndote en una leyenda de los caminos al estilo Robin.
  - **III.2 (El Rey de los Proscritos):** Utilizas el oro para contratar a una banda de asaltantes en el Mercado Negro del Bajo Feudo.
- **Consecuencia:** Carteles de recompensa de 100 monedas de oro son colocados con tu rostro en todo el Reino.

#### **🗡️ RAMA IV: El Pacto del Subsuelo (Camino de la Red de las Sombras)**
- **Detonante:** Pactas con el emisario encapuchado del Sindicato de Contrabandistas de Oakhaven.
- **Sub-destinos:**
  - **IV.1 (Agente Clandestino):** Conviertes la bodega subterránea de cerveza de la taberna en una ruta secreta de mercancías furtivas.
  - **IV.2 (Patrón del Submundo):** Exiges liderar el sector norte del sindicato, convirtiéndote en el amo nocturno de la comarca a tus 20 años.
- **Consecuencia:** La taberna es intocable para el Feudo debido a la influencia de las sombras.

---

### ⚙️ 4. Integración Técnica: Motor Nativo C++ y Rust

El cálculo determinista de las ramificaciones y probabilidades del Epílogo no se ejecuta en capas interpretadas lentas.
- **Rust Core:** Valida la inmutabilidad de los estados, calcula semillas de RNG de eventos y verifica los grafos de decisión sin fugas de memoria.
- **C++ Engine:** Procesa los valores de daño de combate, reducciones por armadura y velocidad de transición entre nodos de la historia a través de JNI.
- **Kotlin & Compose:** Se encarga exclusivamente de la renderización fluida de la UI, animaciones Material Design 3, accesibilidad y reactividad mediante `StateFlow`.
