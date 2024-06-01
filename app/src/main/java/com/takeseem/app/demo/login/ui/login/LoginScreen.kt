package com.takeseem.app.demo.login.ui.login

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.takeseem.app.demo.login.R
import com.takeseem.app.demo.login.ui.components.HeaderText
import com.takeseem.app.demo.login.ui.components.LoginTextField
import com.takeseem.app.demo.login.ui.theme.DemoLoginTheme

val defaultPadding = 16.dp
val itemSpacing = 8.dp

@Composable
fun LoginScreen(
	onSignUpClick: () -> Unit,
) {
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
		
		val context = LocalContext.current
		
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
		
		AlternativeLoginOptions(
			modifier = Modifier
				.fillMaxSize()
				.wrapContentSize(align = Alignment.BottomCenter),
			onIconClick = { _, resId ->
				when (resId) {
					R.drawable.icon_instagram -> {
						Toast.makeText(context, "Instagram login clicked", Toast.LENGTH_SHORT).show()
					}
					R.drawable.icon_github -> {
						Toast.makeText(context, "Github login clicked", Toast.LENGTH_SHORT).show()
					}
					R.drawable.icon_google -> {
						Toast.makeText(context, "Google login clicked", Toast.LENGTH_SHORT).show()
					}
				}
			},
			onSignUpClick = onSignUpClick,
		)
	}
}

@Composable
fun AlternativeLoginOptions(
	modifier: Modifier = Modifier,
	onIconClick: (index: Int, resId: Int) -> Unit,
	onSignUpClick: () -> Unit,
) {
	val iconList = listOf(
		R.drawable.icon_instagram,
		R.drawable.icon_github,
		R.drawable.icon_google,
	)
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		Text(text = "Or Sign in With")
		Row {
			iconList.forEachIndexed { index, resId ->
				Icon(
					painter = painterResource(id = resId),
					contentDescription = "login $index",
					modifier = Modifier
						.size(32.dp)
						.clip(CircleShape)
						.clickable { onIconClick(index, resId) }
				)
				Spacer(Modifier.width(defaultPadding))
			}
		}
		Spacer(Modifier.height(itemSpacing))
		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(text = "Don't have an account?")
			Spacer(Modifier.height(itemSpacing))
			TextButton(onClick = onSignUpClick) {
				Text("Sign up")
			}
		}
	}
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
	DemoLoginTheme {
		LoginScreen(
			onSignUpClick = {}
		)
	}
}