package com.mukul.compose.temp

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun ShowDatePicker() {
    return DatePickerDialog(LocalContext.current).show()
}
