package com.mukul.compose.temp

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

actual fun getRobotFontFamily(): FontFamily {
    return FontFamily(Font(R.font.roboto_bold))
}

@OptIn(ExperimentalResourceApi::class)
actual fun readContent(name: String): String {
    val resource = runBlocking { resource(name).readBytes() }
    return resource.decodeToString()
}