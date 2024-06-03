package com.takeseem.app.demo.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.takeseem.app.demo.login.ui.login.LoginScreen
import com.takeseem.app.demo.login.ui.signup.PolicyScreen
import com.takeseem.app.demo.login.ui.signup.PrivacyScreen
import com.takeseem.app.demo.login.ui.signup.SignupScreen

sealed class Route(val dest: String) {
	data object LoginScreen: Route("screen.login")
	data object SignupScreen: Route("screen.signup")
	data object PolicyScreen: Route("screen.policy")
	data object PrivacyScreen: Route("screen.privacy")
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
					onSignUpClick = {
						navController.navigateToSingleTop(Route.SignupScreen.dest)
					}
				)
			}
			composable(route = Route.SignupScreen.dest) {
				SignupScreen(
					onSignInClick = {
						navController.navigateToSingleTop(Route.LoginScreen.dest)
					},
					onPolicyClick = {
						navController.navigate(Route.PolicyScreen.dest) {
							launchSingleTop = true
						}
					},
					onPrivacyClick = {
						navController.navigate(Route.PrivacyScreen.dest) {
							launchSingleTop = true
						}
					}
				)
			}
			composable(route = Route.PolicyScreen.dest) {
				PolicyScreen() {
					navController.navigateUp()
				}
			}
			composable(route = Route.PrivacyScreen.dest) {
				PrivacyScreen() {
					navController.navigateUp()
				}
			}
		}
	}
}

fun NavHostController.navigateToSingleTop(route: String) {
	navigate(route) {
		popUpTo(graph.findStartDestination().id) {
			saveState = true
		}
		launchSingleTop = true
		restoreState = true
	}
}