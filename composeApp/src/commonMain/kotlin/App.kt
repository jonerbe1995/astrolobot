import androidx.compose.runtime.*
import kotlinx.datetime.LocalDate
import com.jerbeware.astrolobot.AstrologyEngine
import com.jerbeware.astrolobot.RoastRepo

@Composable
fun App() {
    // 1. State for Navigation and Data
    var sunSign by remember { mutableStateOf<String?>(null) }
    var risingSign by remember { mutableStateOf<String?>(null) }

    // 2. Logic to decide which screen to display
    if (sunSign == null || risingSign == null) {
        // First Launch: The Interrogation
        InterrogationScreen { birthDate, hour, minute, longitude ->
            // Use your shared logic from image_827e52.png
            sunSign = AstrologyEngine.getSunSign(birthDate)
            risingSign = AstrologyEngine.calculateRisingSign(hour, minute, longitude)
        }
    } else {
        // Returning or Completed: The Roast
        InsightScreen(
            sun = sunSign!!, 
            rising = risingSign!!,
            onReset = { 
                sunSign = null 
                risingSign = null 
            }
        )
    }
}

@Composable
fun InterrogationScreen(onComplete: (LocalDate, Int, Int, Double) -> Unit) {
    var dateString by remember { mutableStateOf("") } // YYYY-MM-DD
    var timeString by remember { mutableStateOf("") } // HH:MM
    var longitudeString by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text("SYSTEM_ACCESS: BIO-DATA INPUT REQUIRED", color = Color.Green)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = dateString,
            onValueChange = { dateString = it },
            label = { Text("BIRTH_DATE (YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = timeString,
            onValueChange = { timeString = it },
            label = { Text("BIRTH_TIME (HH:MM)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = longitudeString,
            onValueChange = { longitudeString = it },
            label = { Text("LONGITUDE (e.g. -87.6)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                // Parsing logic (add error handling for real use)
                val date = LocalDate.parse(dateString)
                val timeParts = timeString.split(":")
                onComplete(date, timeParts[0].toInt(), timeParts[1].toInt(), longitudeString.toDouble())
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("SUBMIT FOR ANALYSIS")
        }
    }
}

@Composable
fun InsightScreen(sun: String, rising: String, onReset: () -> Unit) {
    val dailyRoast = RoastRepo.getDailyRoast(sun, rising)

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text("TERM_01 > DEEP SCAN RESULTS", color = Color.Green)
        Spacer(Modifier.height(16.dp))

        // This displays the hardcoded roasts you'll write locally
        Text(
            text = dailyRoast,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )

        Spacer(Modifier.height(32.dp))

        Button(onClick = onReset) {
            Text("RE-SUBMIT BIO-DATA")
        }
        
        TextButton(onClick = { /* Logic to open JerbeWare.com */ }) {
            Text("VISIT JERBEWARE.COM", color = Color.Gray)
        }
    }
}