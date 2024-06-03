package com.takeseem.app.demo.login.ui.signup

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.takeseem.app.demo.login.ui.components.HeaderText
import com.takeseem.app.demo.login.ui.components.LoginTextField
import com.takeseem.app.demo.login.ui.theme.DemoLoginTheme
import com.takeseem.app.demo.login.ui.theme.defaultPadding
import com.takeseem.app.demo.login.ui.theme.itemSpacing

@Composable
fun SignupScreen(
	onSignInClick: () -> Unit = {}
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(defaultPadding),
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		val (firstName, setFirstName) = rememberSaveable { mutableStateOf("") }
		val (lastName, setLastName) = rememberSaveable { mutableStateOf("") }
		val (email, setEmail) = rememberSaveable { mutableStateOf("") }
		val (password, setPassword) = rememberSaveable { mutableStateOf("") }
		val (confirmPassword, setConfirmPassword) = rememberSaveable { mutableStateOf("") }
		val (agree, onAgreeChanged) = rememberSaveable { mutableStateOf(false) }
		
		val context = LocalContext.current
		
		HeaderText(
			text = "Sign Up",
			modifier = Modifier.padding(vertical = defaultPadding).align(alignment = Alignment.Start),
		)
		LoginTextField(value = firstName, onValueChange = setFirstName, labelText = "First Name")
		Spacer(Modifier.height(defaultPadding))
		LoginTextField(value = lastName, onValueChange = setLastName, labelText = "Last Name")
		Spacer(Modifier.height(defaultPadding))
		LoginTextField(value = email, onValueChange = setEmail, labelText = "Email", leadingIcon = Icons.Default.Email)
		Spacer(Modifier.height(defaultPadding))
		LoginTextField(
			value = password,
			onValueChange = setPassword,
			labelText = "Password",
			leadingIcon = Icons.Default.Lock,
			keyboardType = KeyboardType.Password
		)
		Spacer(Modifier.height(defaultPadding))
		LoginTextField(
			value = confirmPassword,
			onValueChange = setConfirmPassword,
			labelText = "Confirm Password",
			leadingIcon = Icons.Default.Lock,
			keyboardType = KeyboardType.Password
		)
		Spacer(Modifier.height(defaultPadding))
		
		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			Checkbox(checked = agree, onCheckedChange = onAgreeChanged)
			
			val annotatedString = buildAnnotatedString {
				withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
					append("I agree with")
				}
				append(" ")
				withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
					pushStringAnnotation(tag = "Privacy", annotation = "Privacy")
					append("Privacy")
				}
				append(" And ")
				withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
					pushStringAnnotation(tag = "Policy", annotation = "Policy")
					append("Policy")
				}
			}
			ClickableText(annotatedString) { offset ->
				annotatedString.getStringAnnotations(offset, offset).forEach {
					when (it.tag) {
						"Privacy" -> {
							Toast.makeText(context, "Privacy Clicked", Toast.LENGTH_SHORT).show()
						}
						"Policy" -> {
							Toast.makeText(context, "Policy Clicked", Toast.LENGTH_SHORT).show()
						}
					}
				}
			}
		}
		
		Spacer(modifier = Modifier.height(defaultPadding + itemSpacing))
		Button(
			onClick = { /*TODO*/ },
			modifier = Modifier.fillMaxWidth(),
		) {
			Text(text = "Sign Up")
		}
		
		Spacer(Modifier.height(defaultPadding))
		val signInAnnotation = buildAnnotatedString {
			withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
				append("Already have an account? ")
			}
			append("  ")
			withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
				pushStringAnnotation(tag = "Sign In", annotation = "Sign In")
				append("Sign In")
			}
		}
		ClickableText(signInAnnotation) { offset ->
			signInAnnotation.getStringAnnotations(offset, offset).forEach {
				if (it.tag == "Sign In") {
					onSignInClick()
				}
			}
		}
	}
}

@Preview(showSystemUi = true)
@Composable
fun PreSignup() {
	DemoLoginTheme {
		SignupScreen()
	}
}