package com.mukul.compose.temp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

sealed interface BottomSheet {
    object Sheet1: BottomSheet
    object Sheet2: BottomSheet
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetMainView() {
    val currentSheet = remember { mutableStateOf<BottomSheet?>(null) }
    val state = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    LaunchedEffect(currentSheet.value) {
        if (currentSheet.value != null) {
            state.show()
        } else {
            state.hide()
        }
    }

    fun openSheet(sheet: BottomSheet) {
        if(currentSheet.value == sheet) currentSheet.value = null
        else currentSheet.value = sheet
    }

    ModalBottomSheetLayout(
        sheetState = state,
        sheetContent = {
            when(currentSheet.value) {
                is BottomSheet.Sheet1 -> {
                    BottomSheet1()
                }
                is BottomSheet.Sheet2 -> {
                    BottomSheet2()
                }
                else -> {}
            }
        },
        modifier = Modifier.fillMaxSize(),
        sheetShape = RoundedCornerShape(10.dp),
        content = {
            Column(modifier = Modifier.fillMaxSize()) {
                Button(onClick = {
                    openSheet(BottomSheet.Sheet1)
                }) {
                    Text("Bottom Sheet 1")
                }
                Button(onClick = {
                    openSheet(BottomSheet.Sheet2)
                }) {
                    Text("Bottom Sheet 2")
                }
            }
        }
    )

}

@Composable
fun BottomSheet1() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Bottom Sheet 1")
        ShowDatePicker() //TODO: Modifier
    }
}

@Composable
fun BottomSheet2() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Bottom Sheet 2")
        MapView(modifier = Modifier.fillMaxWidth().size(500.dp))
    }
}