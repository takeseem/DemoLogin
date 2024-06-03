package com.takeseem.app.demo.login.ui.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PolicyScreen(
	onFinish: () -> Unit
) {
	Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
		Column {
			Text(text = "Policy Screen")
			Button(onClick = onFinish) {
				Text(text = "Finish")
			}
		}
	}
}