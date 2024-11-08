package mantum.mobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UserProfile(name: String, boxsize: Int) {
    val initials = name.split(" ").take(2).joinToString(" ").take(2).uppercase()

    Box(
        modifier = Modifier
            .size(boxsize.dp)
            .background(MaterialTheme.colors.primary, shape = CircleShape)
            .border(2.dp, Color.White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials,
            style = MaterialTheme.typography.h5.copy(color = Color.White)
        )
    }
}
