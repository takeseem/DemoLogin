package com.takeseem.app.demo.login.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.takeseem.app.demo.login.ui.components.HeaderText
import com.takeseem.app.demo.login.ui.theme.DemoLoginTheme
import com.takeseem.app.demo.login.ui.theme.defaultPadding

@Composable
fun SignupScreen() {
	Column(
		modifier = Modifier.fillMaxSize().padding(defaultPadding),
	) {
		HeaderText(text = "Sign Up", modifier = Modifier.padding(vertical = defaultPadding))
	}
}

@Preview(showSystemUi = true)
@Composable
fun PreSignup() {
	DemoLoginTheme {
		SignupScreen()
	}
}