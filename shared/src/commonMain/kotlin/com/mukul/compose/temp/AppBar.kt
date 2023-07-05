package com.mukul.compose.temp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Checkbox
import androidx.compose.material.IconButton
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarMainView() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Add, null)
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.White
            ) {
                BottomNavigationItem(
                    onClick = {},
                    icon = { Icon(Icons.Default.Phone, null) },
                    selected = false,
                    label = { Text("Phone") },
                    alwaysShowLabel = true,
                    enabled = true
                )
                BottomNavigationItem(
                    onClick = {},
                    icon = { Icon(Icons.Default.Home, null) },
                    selected = false,
                    enabled = true,
                    label = { Text("Home") },
                    alwaysShowLabel = true,
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .then(Modifier.padding(top = 30.dp))
        ) {
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            TextButton(
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
                    .background(
                        Color.Blue.copy(alpha = 0.3f)
                    ),
                onClick = {},
                content = {
                    Text("Click me")
                }
            )
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            Checkbox(
                onCheckedChange = {},
                checked = true
            )
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            RadioButton(
                selected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            TextField(
                value = "Type here",
                onValueChange = {}
            )
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            Card(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Blue.copy(alpha = 0.2f)),
            ) {
                Text(
                    modifier = Modifier.padding(25.dp),
                    text = "This is card"
                )
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            CircularProgressIndicator()
        }
    }
}
