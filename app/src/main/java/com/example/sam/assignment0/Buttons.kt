package com.example.sam.assignment0

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun Buttons(
    modifier: Modifier = Modifier
) {
    val highChance = 0.75
    val medChance = 0.5
    val lowChance = 0.25
    var numClicks by remember { mutableIntStateOf(0) }
    var output by remember { mutableStateOf(false) } // doesn't matter what default, won't be displayed until a button clicked
    var display by remember { mutableStateOf(false) }
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Text("sjhallid,1873625")
        if(display) {
            Text(text = (if (output) "Yes" else "No"))
        }
        else{
            Text("Do you want to go?")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            modifier = Modifier.padding(vertical = 12.dp).fillMaxWidth(),
            onClick = {
                display = true
                output = chance(highChance)
                numClicks++
            }
        ) {
            Text("Really want")
        }
        Button(
            modifier = Modifier.padding(vertical = 12.dp).fillMaxWidth(),
            onClick = {
                display = true
                output = chance(medChance)
                numClicks++
            }
        ) {
            Text("50/50 want")
        }
        Button(
            modifier = Modifier.padding(vertical = 12.dp).fillMaxWidth(),
            onClick = {
                display = true
                output = chance(lowChance)
                numClicks++
            }
        ) {
            Text("kinda want")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text("Buttons pressed: $numClicks")
    }
}


fun chance(percentage: Double): Boolean{
    return Random.nextFloat() < percentage
}