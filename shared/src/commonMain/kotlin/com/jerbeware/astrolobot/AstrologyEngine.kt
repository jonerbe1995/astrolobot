package com.jerbeware.astrolobot

import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month

object AstrologyEngine {
    fun getSunSign(date: LocalDate): String {
        return when (date.month) {
            Month.JANUARY -> if (date.dayOfMonth <= 19) "Capricorn" else "Aquarius"
            Month.FEBRUARY -> if (date.dayOfMonth <= 18) "Aquarius" else "Pisces"
            Month.MARCH -> if (date.dayOfMonth <= 20) "Pisces" else "Aries"
            Month.APRIL -> if (date.dayOfMonth <= 19) "Aries" else "Taurus"
            Month.MAY -> if (date.dayOfMonth <= 20) "Taurus" else "Gemini"
            Month.JUNE -> if (date.dayOfMonth <= 20) "Gemini" else "Cancer"
            Month.JULY -> if (date.dayOfMonth <= 22) "Cancer" else "Leo"
            Month.AUGUST -> if (date.dayOfMonth <= 22) "Leo" else "Virgo"
            Month.SEPTEMBER -> if (date.dayOfMonth <= 22) "Virgo" else "Libra"
            Month.OCTOBER -> if (date.dayOfMonth <= 22) "Libra" else "Scorpio"
            Month.NOVEMBER -> if (date.dayOfMonth <= 21) "Scorpio" else "Sagittarius"
            Month.DECEMBER -> if (date.dayOfMonth <= 21) "Sagittarius" else "Capricorn"
            else -> "Unknown"
        }
    }

    // A simplified MVP calculation for the Rising sign (Ascendant)
    fun calculateRisingSign(hour: Int, minute: Int, longitude: Double): String {
        // In a real app, we'd use complex sidereal time math.
        // For the MVP "Astrolobot" parody, we'll use a simplified 2-hour window logic.
        val signs = listOf("Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", 
                           "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces")
        
        // This is a placeholder for the actual complex calculation
        val index = (hour / 2) % 12
        return signs[index]
    }
}