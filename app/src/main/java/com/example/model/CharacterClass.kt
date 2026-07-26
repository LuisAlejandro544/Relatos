package com.example.model

enum class CharacterClass(
    val title: String,
    val description: String,
    val baseHp: Int,
    val weaponName: String,
    val armorName: String,
    val iconEmoji: String
) {
    GUERRERO(
        title = "Guerrero Novato",
        description = "20 años. Trabajaste años en la taberna familiar. Empiezas desde cero con valor y acero oxidado.",
        baseHp = 100,
        weaponName = "Espada Mella de Madera",
        armorName = "Peto de Cuero Desgastado",
        iconEmoji = "🗡️"
    ),
    MAGO(
        title = "Mago Arcano",
        description = "Erudito de las artes místicas. Lanza hechizos devastadores.",
        baseHp = 80,
        weaponName = "Báculo de Fuego",
        armorName = "Túnica de Seda Estelar",
        iconEmoji = "🪄"
    ),
    PICARO(
        title = "Pícaro",
        description = "Ágil y sigiloso. Experto en esquiva y golpes críticos.",
        baseHp = 95,
        weaponName = "Dagas Gemelas",
        armorName = "Capa de Cuero",
        iconEmoji = "🗡️"
    ),
    EXPLORADOR(
        title = "Explorador",
        description = "Rastreador astuto del bosque. Certero con el arco.",
        baseHp = 100,
        weaponName = "Arco de Roble",
        armorName = "Chaleco de Gran Espectro",
        iconEmoji = "🏹"
    )
}
