package mantum.mobile.ui.view.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import mantum.mobile.ui.components.ListUsers
import mantum.mobile.repository.viewmodel.UserViewModel

@Composable
fun UsersScreen(viewModel: UserViewModel, navController: NavController) {

    LaunchedEffect(Unit) {
        viewModel.getUsersList()
    }

    val users = viewModel.users.value
    val isLoading = viewModel.isLoading.value
    val error = viewModel.error.value

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Users list",
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)
                }   )
        }) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize()){
            if(isLoading){
                CircularProgressIndicator(modifier = Modifier.align((Alignment.Center)))
            }

            if(error != null){
                Text(text = error, color = Color.Red, modifier = Modifier.align(Alignment.Center))
            }

            if(users.isNotEmpty()) {
                LazyColumn {
                    items(users) { user ->
                        ListUsers(user, navController)
                    }
                }
            }
        }
    }

}


