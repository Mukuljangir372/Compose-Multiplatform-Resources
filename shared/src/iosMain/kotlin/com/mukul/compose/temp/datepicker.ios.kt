package com.mukul.compose.temp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.unit.dp
import platform.UIKit.UIDatePicker
import platform.UIKit.UIDatePickerMode
import platform.UIKit.UIDatePickerStyle
import platform.UIKit.UIView

@Composable
actual fun ShowDatePicker() {
    UIKitView(modifier = Modifier.clip(RoundedCornerShape(12.dp)).padding(12.dp)
        .size(200.dp) //TODO: modifier should be come from parent
        , update = {}, factory = {
            val uiView = UIView()

            val picker = UIDatePicker()
            picker.setDatePickerMode(UIDatePickerMode.UIDatePickerModeDate)
            picker.setPreferredDatePickerStyle(UIDatePickerStyle.UIDatePickerStyleInline)

            uiView.addSubview(picker)

            picker.translatesAutoresizingMaskIntoConstraints = false
            picker.centerXAnchor.constraintEqualToAnchor(anchor = uiView.centerXAnchor).active =
                true
            picker.leadingAnchor.constraintEqualToAnchor(anchor = uiView.leadingAnchor).active =
                true
            picker.trailingAnchor.constraintEqualToAnchor(anchor = uiView.trailingAnchor).active =
                true
            picker.topAnchor.constraintEqualToAnchor(anchor = uiView.topAnchor).active = true
            picker.bottomAnchor.constraintEqualToAnchor(anchor = uiView.bottomAnchor).active = true

            uiView
        })
}