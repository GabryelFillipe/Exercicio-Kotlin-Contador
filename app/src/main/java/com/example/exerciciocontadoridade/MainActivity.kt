package com.example.exerciciocontadoridade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exerciciocontadoridade.ui.theme.ExercicioContadorIdadeTheme
import kotlin.toString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercicioContadorIdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContadorScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun InfoInicial(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Qual é a sua Idade?",
            textAlign = TextAlign.Center,
            color = Color(0, 174, 255, 244),
            modifier = Modifier.fillMaxWidth(),
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = "Aperte os botões para informar sua idade",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ContadorScreen(modifier: Modifier = Modifier) {
    var idade by remember { mutableStateOf(0) }

    val status = if (idade >= 18) "Maior" else "Menor"

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CabecalhoContador()

        Spacer(modifier = Modifier.height(32.dp))

        DisplayIdade(valor = idade)

        Spacer(modifier = Modifier.height(16.dp))

        PainelControles(
            onIncrementar = { if (idade < 180) idade++ },
            onDecrementar = { if (idade > 0) idade-- }
        )

        Spacer(modifier = Modifier.height(24.dp))

        RodapeStatus(status = status)
    }
}

@Composable
fun CabecalhoContador() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Qual é a sua Idade?",
            color = Color(0xFF00AEFF),
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Aperte os botões para informar",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun DisplayIdade(valor: Int) {
    Text(
        text = valor.toString(),
        fontSize = 64.sp,
        fontWeight = FontWeight.Black,
        color = Color.DarkGray
    )
}

@Composable
fun PainelControles(onIncrementar: () -> Unit, onDecrementar: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BotaoAcao(label = "-", onClick = onDecrementar)
        BotaoAcao(label = "+", onClick = onIncrementar)
    }
}

@Composable
fun BotaoAcao(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00AEFF)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.width(80.dp).height(70.dp)
    ) {
        Text(text = label, fontSize = 28.sp)
    }
}

@Composable
fun RodapeStatus(status: String) {
    Text(
        text = "Você é $status de idade",
        color = Color(0xFF00AEFF),
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    )
}