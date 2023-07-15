package com.mukul.compose.temp

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Density
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.LoadState
import org.jetbrains.compose.resources.rememberImageVector
import org.jetbrains.compose.resources.resource
import platform.Foundation.NSString

@OptIn(ExperimentalResourceApi::class)
actual fun getRobotFontFamily(): FontFamily {
    val resource = runBlocking { resource("font/roboto_bold.ttf").readBytes() }
    return FontFamily(Font("roboto_bold", resource))
}

@OptIn(ExperimentalResourceApi::class)
actual fun readContent(name: String): String {
    val resource = runBlocking { resource(name).readBytes() }
    return resource.decodeToString()
}