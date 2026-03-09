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
fun ContadorScreen(modifier: Modifier = Modifier) {



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            InfoInicial()
            BtnRow()
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
fun BtnRow(modifier: Modifier = Modifier) {

    var contador by remember {
        mutableStateOf(0)
    }
        Text(
            text = contador.toString(),
            fontSize = 32.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    Spacer(modifier = Modifier.height(16.dp))
    Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    if (contador > 0) {
                        contador -= 1
                    }

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0, 174, 255, 244),
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "-",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.W500
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    if (contador < 180) {
                        contador += 1
                    }
                    contador += 1
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0, 174, 255, 244),
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.W500
                )
            }
        }
        var resposta = ""
        if (contador > 18) {
            resposta = "Maior"
        } else {
            resposta = "Menor"
        }
    Spacer(modifier = Modifier.height(16.dp))
    RespostaRow(resposta = resposta)
    }


@Composable
fun RespostaRow(modifier: Modifier = Modifier, resposta: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Você é ${resposta} de idade",
            textAlign = TextAlign.Center,
            color = Color(0, 174, 255, 244),
            )
    }
}
