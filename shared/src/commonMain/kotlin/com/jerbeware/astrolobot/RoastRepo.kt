package com.jerbeware.astrolobot

object RoastRepo {
    private val roasts = mapOf(
        "Aries" to "Oh, an Aries. How original. I bet you've already tried to fight this app twice.",
        "Scorpio" to "Scorpio detected. Initializing privacy shields because you're definitely hiding something.",
        "Gemini" to "A Gemini? Great. I'll just talk to one of you while the other complains.",
        "Default" to "Calculation complete. Results: You are a standard carbon-based lifeform with delusions of grandeur."
    )

    fun getDailyRoast(sun: String, rising: String): String {
        val sunRoast = roasts[sun] ?: roasts["Default"]!!
        return "SUN: $sun | RISING: $rising\n\nANALYSIS: $sunRoast"
    }
}