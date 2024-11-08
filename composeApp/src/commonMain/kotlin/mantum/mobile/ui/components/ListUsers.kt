package mantum.mobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mantum.mobile.data.model.User

@Composable
fun ListUsers(user: User, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {  navController.navigate("userDetail/${user.id}") },
        verticalAlignment = Alignment.CenterVertically
    ) {

        UserProfile(name = user.name, boxsize = 50)
        Spacer(modifier = Modifier.width(16.dp))

        Column() {
            Text(text = user.name, style = MaterialTheme.typography.h6)
            Text(text = user.phone, style = MaterialTheme.typography.body2)
        }
    }
}

