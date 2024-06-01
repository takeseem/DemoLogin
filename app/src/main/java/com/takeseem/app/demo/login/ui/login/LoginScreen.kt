package com.takeseem.app.demo.login.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.takeseem.app.demo.login.ui.components.HeaderText
import com.takeseem.app.demo.login.ui.components.LoginTextField
import com.takeseem.app.demo.login.ui.theme.DemoLoginTheme

val defaultPadding = 16.dp
val itemSpacing = 8.dp

@Composable
fun LoginScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(defaultPadding),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		val (userName, setUsername) = rememberSaveable {
			mutableStateOf("")
		}
		val (password, setPassword) = rememberSaveable {
			mutableStateOf("")
		}
		val (checked, onCheckedChange) = rememberSaveable {
			mutableStateOf(true)
		}
		
		HeaderText(text = "Login", modifier = Modifier
			.padding(vertical = defaultPadding)
			.align(Alignment.Start))
		
		LoginTextField(
			modifier = Modifier.fillMaxWidth(),
			value = userName,
			onValueChange = setUsername,
			labelText = "Username",
			leadingIcon = Icons.Default.Person
		)
		Spacer(Modifier.height(itemSpacing))
		LoginTextField(
			modifier = Modifier.fillMaxWidth(),
			value = password,
			onValueChange = setPassword,
			labelText = "Password",
			leadingIcon = Icons.Default.Lock,
			keyboardType = KeyboardType.Password,
			visualTransformation = PasswordVisualTransformation(),
		)
		Spacer(Modifier.height(itemSpacing))
		
		Row(
			modifier = Modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween,
		) {
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier.clickable { onCheckedChange(!checked) },
			) {
				Checkbox(checked = checked, onCheckedChange = onCheckedChange)
				Text(text = "Remember me")
			}
			TextButton(onClick = {}) {
				Text("Forgot password?")
			}
		}
		
		Spacer(Modifier.height(itemSpacing))
		Button(
			onClick = {},
			modifier = Modifier.fillMaxWidth()
		) {
			Text("Login")
		}
	}
}

@Preview
@Composable
fun LoginScreenPreview() {
	DemoLoginTheme {
		LoginScreen()
	}
}