package com.example.instagram.android.auth.login

import androidx.compose.runtime.Composable
import com.destinations.HomeDestination
import com.destinations.LoginDestination
import com.destinations.SignUpDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun Login(
    navigator: DestinationsNavigator
) {
    val viewModel: LoginViewModel = koinViewModel()
    LoginScreen(
        uiState = viewModel.uiState,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onSignInClick = viewModel::signIn,
        onNavigateToHome = {
            navigator.navigate(HomeDestination){
                popUpTo(LoginDestination.route){inclusive = true}
            }
        },
        onNavigateToSignup = {
            navigator.navigate(SignUpDestination.route){
                popUpTo(LoginDestination.route){
                    inclusive = true
                }
            }
        }
    )
}