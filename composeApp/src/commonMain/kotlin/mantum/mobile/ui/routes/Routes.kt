package mantum.mobile.ui.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import mantum.mobile.ui.view.detail.DetailScreen
import mantum.mobile.ui.view.home.UsersScreen
import mantum.mobile.repository.viewmodel.UserViewModel

sealed class Screen(val route: String) {
    data object UserList : Screen("userList")
    data object UserDetail : Screen("userDetail/{userId}")
}

@Composable
fun Routes(userViewModel: UserViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.UserList.route
    ) {
        composable(Screen.UserList.route) {
            UsersScreen(
                viewModel = userViewModel,
                navController = navController
            )
        }

        composable(
            route = Screen.UserDetail.route,
            arguments = listOf(
                navArgument("userId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("userId") ?: 0
            val user = userViewModel.users.value.find { it.id == userId }

            user?.let {
                DetailScreen(
                    user = it,
                    navController = navController
                )
            }
        }
    }
}
