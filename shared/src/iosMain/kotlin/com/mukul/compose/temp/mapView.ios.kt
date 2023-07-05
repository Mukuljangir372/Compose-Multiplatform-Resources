package com.mukul.compose.temp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import platform.MapKit.MKMapView

@Composable
actual fun MapView(modifier: Modifier) {
    val mkMapView = MKMapView()
    val view = UIKitView(
        factory = { mkMapView },
        modifier = modifier,
        update = {

        }
    )
}