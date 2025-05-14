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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.KeyboardType

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
@Composable
fun User_InformationScreen(navController: NavController) {
    var selectedLanguage by remember { mutableStateOf("English") }
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
            text = "Appointment Booking",
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

        Text(text = "What language would you like?")
        ExposedDropdownMenuBox(
            expanded = false,
            onExpandedChange = {}
        ) {
            TextField(
                value = selectedLanguage,
                onValueChange = { selectedLanguage = it },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
                label = { Text("Language") },
                trailingIcon = {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            )
        }

        Text(text = "Preferred race?")
        OutlinedTextField(
            value = preferredRace,
            onValueChange = { preferredRace = it },
            label = { Text("Enter race") },
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "Appointment Details", fontWeight = FontWeight.SemiBold)

        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("DATE") },
            placeholder = { Text("YY/MM/DD") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("TIME") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = duration,
            onValueChange = { duration = it },
            label = { Text("DURATION") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Notes") },
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
                Text("Back")
            }

            Button(
                onClick = { navController.navigate("Interface_2_consult") },
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Next")
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
