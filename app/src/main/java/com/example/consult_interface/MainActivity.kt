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
fun User_InformationScreen(navController: NavController)
{

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
