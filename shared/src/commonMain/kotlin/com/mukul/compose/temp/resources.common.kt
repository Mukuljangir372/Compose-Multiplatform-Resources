package com.mukul.compose.temp

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily

/**
 * NOTE: You cannot access strings.xml without using any resource generator like MOKO.
 */

/**
 * --------------------
 * To access the fonts -
 *
 * Text(
 *    modifier = Modifier,
 *    text = "Hello",
 *    fontFamily = getRobotFontFamily(),
 *  )
 */
expect fun getRobotFontFamily(): FontFamily

/**
 * --------------------
 * To access the images.
 *
 * In case of android - (common module)
 * Image(
 *      modifier = Modifier,
 *      painter = painterResource("res/drawable/star.png"),
 *      contentDescription = null
 *   )
 *
 * In case of iOS - (common module)
 * Image(
 *      modifier = Modifier,
 *      painter = painterResource("drawable/star.png"),
 *      contentDescription = null
 *   )
 */

/**
 * --------------------
 * To access RAW files like json, txt etc.
 *
 * In case of android - (common module)
 * Text(
 *      modifier = Modifier,
 *      text = readContent("res/raw/android1.txt"),
 *      contentDescription = null
 *   )
 *
 * In case of iOS - (common module)
 * Text(
 *      modifier = Modifier,
 *      text = readContent("raw/android1.txt"),
 *      contentDescription = null
 *   )
 *
 */

expect fun readContent(name: String): String
