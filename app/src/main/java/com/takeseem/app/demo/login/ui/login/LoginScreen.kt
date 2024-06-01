package com.takeseem.app.demo.login.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.takeseem.app.demo.login.ui.components.HeaderText

val defaultPadding = 16.dp

@Composable
fun LoginScreen() {
	Column(
		modifier = Modifier.fillMaxSize().padding(defaultPadding),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		HeaderText(text = "Login", modifier = Modifier.padding(vertical = defaultPadding).align(Alignment.Start))
	}
}

@Preview
@Composable
fun LoginScreenPreview() {
	LoginScreen()
}