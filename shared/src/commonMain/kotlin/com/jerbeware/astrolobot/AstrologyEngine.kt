package com.jerbeware.astrolobot.shared

import kotlinx.datetime.*
import kotlin.math.floor

object AstrologyEngine {

    fun getSunSign(date: LocalDate): String {
        val day = date.dayOfMonth
        return when (date.monthNumber) {
            1 -> if (day < 20) "Capricorn" else "Aquarius"
            2 -> if (day < 19) "Aquarius" else "Pisces"
            3 -> if (day < 21) "Pisces" else "Aries"
            4 -> if (day < 20) "Aries" else "Taurus"
            5 -> if (day < 21) "Taurus" else "Gemini"
            6 -> if (day < 21) "Gemini" else "Cancer"
            7 -> if (day < 23) "Cancer" else "Leo"
            8 -> if (day < 23) "Leo" else "Virgo"
            9 -> if (day < 23) "Virgo" else "Libra"
            10 -> if (day < 23) "Libra" else "Scorpio"
            11 -> if (day < 22) "Scorpio" else "Sagittarius"
            12 -> if (day < 22) "Sagittarius" else "Capricorn"
            else -> "Unknown"
        }
    }

    /**
     * Simplified Ascendant Calculation for MVP
     */
    fun calculateRisingSign(hour: Int, minute: Int, longitude: Double): String {
        // Rough estimate of Sidereal Time at 00:00 local
        // In a full app, this would use a Julian Date calculation
        val timeInHours = hour + (minute / 60.0)
        
        // Adjust for longitude (15 degrees per hour)
        var lst = (timeInHours + (longitude / 15.0)) % 24
        if (lst < 0) lst += 24

        val signs = listOf(
            "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", 
            "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"
        )
        
        // Map the 24-hour cycle to the 12 signs (approx 2 hours per sign)
        val index = (floor(lst / 2.0).toInt()) % 12
        return signs[index]
    }
}