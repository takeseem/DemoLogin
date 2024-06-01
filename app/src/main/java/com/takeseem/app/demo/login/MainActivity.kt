package com.takeseem.app.demo.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.takeseem.app.demo.login.ui.theme.DemoLoginTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			DemoLoginTheme {
				Surface {
					val navController = rememberNavController()
					AppNavigation(navController = navController)
				}
			}
		}
	}
}
