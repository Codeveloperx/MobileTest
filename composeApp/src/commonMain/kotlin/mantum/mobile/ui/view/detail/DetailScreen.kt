package mantum.mobile.ui.view.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mantum.mobile.data.model.User
import mantum.mobile.ui.components.InfoRow
import mantum.mobile.ui.components.Section
import mantum.mobile.ui.components.UserProfile

@Composable
fun DetailScreen(
    user: User,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = user.name) },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                UserProfile(name = user.name, boxsize = 120)
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 5.dp, bottom = 8.dp )
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Section(title = "Personal Information") {
                        InfoRow(label = "Username:", value = user.username)
                        InfoRow(label = "Email:", value = user.email)
                        InfoRow(label = "Phone:", value = user.phone)
                        InfoRow(label = "Website:", value = user.website)
                    }

                    Divider(modifier = Modifier.padding(vertical = 16.dp))

                    Section(title = "Address") {
                        InfoRow(label = "Street:", value = user.address.street)
                        InfoRow(label = "Suite:", value = user.address.suite)
                        InfoRow(label = "City:", value = user.address.city)
                        InfoRow(label = "Zipcode:", value = user.address.zipcode)

                    }

                    Divider(modifier = Modifier.padding(vertical = 16.dp))

                    Section(title = "Company") {
                        InfoRow(label = "Name:", value = user.company.name)
                    }
                }
            }
        }
    }
}


