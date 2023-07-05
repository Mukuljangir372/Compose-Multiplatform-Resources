package com.mukul.compose.temp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * These Composable functions are not following the best practises.
 * These are the showcase of UI components on iOS and Android if these are
 * working.
 */
@Composable
fun App() {
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
            NavigationMainView()
        }
    }
}

