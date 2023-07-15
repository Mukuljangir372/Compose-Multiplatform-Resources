package com.mukul.compose.temp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * These Composable functions are not following the best practises.
 * These are the showcase of UI components on iOS and Android if these are
 * working.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
            Text(
                modifier = Modifier,
                text = "Hello",
                fontFamily = getRobotFontFamily(),
            )
            Image(
                modifier = Modifier,
                painter = painterResource("drawable/star.png"),
                contentDescription = null
            )
        }
    }
}

