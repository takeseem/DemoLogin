package com.takeseem.app.demo.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.takeseem.app.demo.login.ui.login.LoginScreen

sealed class Route(val dest: String) {
	data object LoginScreen: Route("screen.login")
}

@Composable
fun AppNavigation(
	navController: NavHostController
) {
	NavHost(
		navController = navController,
		startDestination = "login_flow",
	) {
		navigation(startDestination = Route.LoginScreen.dest, route = "login_flow") {
			composable(route = Route.LoginScreen.dest) {
				LoginScreen(
					onSignUpClick = {}
				)
			}
		}
	}
}
