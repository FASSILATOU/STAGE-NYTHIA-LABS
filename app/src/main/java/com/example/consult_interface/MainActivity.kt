package com.example.consult_interface

// Importations nécessaires
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.consult_interface.R
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem






// Activité principale
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Contenu principal défini avec Jetpack Compose
        setContent {
            val navController = rememberNavController()

            // Système de navigation entre écrans
            NavHost(navController = navController, startDestination = "login") {
                composable("Interface_1_consult") {
                    User_InformationScreen(navController)
                }
                composable("Interface_2_consult") {
                    User_SymptomScreen(navController)
                }
                composable("Interface_3_consult") {
                    User_DoctorScreen(navController)
                }
            }
        }
    }
}
// (UZIEL) C'est la partie ou l'utilisateur entre son age et autre 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun User_InformationScreen(navController: NavController) {
    var selectedLanguage by remember { mutableStateOf("English") }
    var expanded by remember { mutableStateOf(false) }
    val languageOptions = listOf("English", "French", "Spanish")

    val title = when (selectedLanguage) {
        "French" -> "Réservation de rendez-vous"
        "Spanish" -> "Reserva de cita"
        else -> "Appointment Booking"
    }
    val languageQuestion = when (selectedLanguage) {
        "French" -> "Quelle langue souhaitez-vous ?"
        "Spanish" -> "¿Qué idioma prefieres?"
        else -> "What language would you like?"
    }
    val languageLabel = when(selectedLanguage) {
        "French" -> "Langue"
        "Spanish" -> "Idioma"
        else -> "Language"
    }
    val preferredRaceText = when (selectedLanguage) {
        "French" -> "Race préférée ?"
        "Spanish" -> "Raza preferida?"
        else -> "Preferred race?"
    }
    val preferredRaceLabel = when(selectedLanguage) {
        "French" -> "Entrez la race"
        "Spanish" -> "Ingrese raza"
        else -> "Enter race"
    }
    val appointmentDetails = when (selectedLanguage) {
        "French" -> "Détails du rendez-vous"
        "Spanish" -> "Detalles de la cita"
        else -> "Appointment Details"
    }
    val dateLabel = when(selectedLanguage) {
        "French" -> "DATE"
        "Spanish" -> "FECHA"
        else -> "DATE"
    }
    val datePlaceholder = when(selectedLanguage) {
        "French" -> "JJ/MM/AAAA"
        "Spanish" -> "DD/MM/AAAA"
        else -> "YY/MM/DD"
    }
    val timeLabel = when(selectedLanguage) {
        "French" -> "HEURE"
        "Spanish" -> "HORA"
        else -> "TIME"
    }
    val durationLabel = when(selectedLanguage) {
        "French" -> "DURÉE"
        "Spanish" -> "DURACIÓN"
        else -> "DURATION"
    }
    val notesLabel = when(selectedLanguage) {
        "French" -> "NOTES"
        "Spanish" -> "NOTAS"
        else -> "NOTES"
    }
    val backText = when(selectedLanguage) {
        "French" -> "Retour"
        "Spanish" -> "Atrás"
        else -> "Back"
    }
    val nextText = when(selectedLanguage) {
        "French" -> "Suivant"
        "Spanish" -> "Siguiente"
        else -> "Next"
    }

    var preferredRace by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("24:00") }
    var duration by remember { mutableStateOf("24:00") }
    var notes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        LinearProgressIndicator(
            progress = 0.33f,
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF8A56AC),
            trackColor = Color(0xFFE0D8F6)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = languageQuestion, fontWeight = FontWeight.SemiBold)
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedLanguage,
                onValueChange = {},
                readOnly = true,
                label = { Text(languageLabel) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                languageOptions.forEach { language ->
                    DropdownMenuItem(
                        text = { Text(language) },
                        onClick = {
                            selectedLanguage = language
                            expanded = false
                        }
                    )
                }
            }
        }

        Text(text = preferredRaceText, fontWeight = FontWeight.SemiBold)
        OutlinedTextField(
            value = preferredRace,
            onValueChange = { preferredRace = it },
            label = { Text(preferredRaceLabel) },
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = appointmentDetails, fontWeight = FontWeight.SemiBold)

        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text(dateLabel) },
            placeholder = { Text(datePlaceholder) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = time,
            onValueChange = { time = it },
            label = { Text(timeLabel) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = duration,
            onValueChange = { duration = it },
            label = { Text(durationLabel) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text(notesLabel) },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Action pour revenir ou quitter */ },
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(backText)
            }

            Button(
                onClick = { navController.navigate("Interface_2_consult") },
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(nextText)
            }
        }
    }
}


// FASSILATOU
@Composable
fun User_SymptomScreen(navController: NavController)
{

}
// FASSILATOU
@Composable
fun User_DoctorScreen(navController: NavController)
{

}


// Aperçus pour Android Studio
@Preview(showBackground = true)
@Composable
fun User_InformationScreenPreview() {
    val mockNavController = rememberNavController()
    User_InformationScreen(mockNavController)
}

@Preview(showBackground = true)
@Composable
fun User_SymptomScreenPreview() {
    val mockNavController = rememberNavController()
    User_SymptomScreen(mockNavController)
}

@Preview(showBackground = true)
@Composable
fun User_DoctorScreenPreview() {
    val mockNavController = rememberNavController()
    User_DoctorScreen(mockNavController)
}
