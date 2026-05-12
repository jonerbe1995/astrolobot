object RoastRepository {
    private val roasts = mapOf(
        "Aries" to "You are a spark plug with no engine. Loud, vibrating, and going nowhere.",
        "Taurus" to "You have the emotional flexibility of a brick wall. And similar charisma.",
        "Gemini" to "Two personalities and I don't care for either of them. Pick a struggle.",
        "Cancer" to "A walking emotional sponge. Dry out. It’s embarrassing.",
        "Leo" to "The world is a stage, but you're just the person blocking the exit sign.",
        "Virgo" to "Your perfectionism is a trauma response. Also, your desk is still messy.",
        "Libra" to "Decisiveness of a wet noodle. Pick a side before I pick one for you.",
        "Scorpio" to "Edgy. Secretive. We get it. You’re a mystery no one wants to solve.",
        "Sagittarius" to "A 'wanderer' is just a fancy word for someone who is chronically lost.",
        "Capricorn" to "Corporate drone energy. Your tombstone will be a LinkedIn post.",
        "Aquarius" to "You’re not 'unique,' you’re just difficult to talk to.",
        "Pisces" to "Delusional. The 'signs' aren't talking to you; you're just daydreaming again."
    )

    fun getDailyRoast(sun: String, rising: String): String {
        val mainText = roasts[sun] ?: "I've seen better configurations in a landfill."
        return "SYSTEM ANALYSIS:\nSun in $sun. Rising in $rising.\n\n$mainText\n\nYour $rising rising is doing its best to mask the disaster that is your $sun sun. It is failing."
    }
}