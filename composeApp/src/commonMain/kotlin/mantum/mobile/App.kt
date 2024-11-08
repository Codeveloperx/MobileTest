package mantum.mobile

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import mantum.mobile.data.remote.ApiServiceImpl
import mantum.mobile.data.remote.KtorClient
import mantum.mobile.repository.UserRepository
import mantum.mobile.ui.routes.Routes
import mantum.mobile.repository.viewmodel.UserViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val client = KtorClient().getClient()
        val apiService = remember { ApiServiceImpl(client) }
        val userRepository = remember { UserRepository(apiService) }
        val userViewModel = remember { UserViewModel(userRepository) }

        Routes(userViewModel)
    }
}