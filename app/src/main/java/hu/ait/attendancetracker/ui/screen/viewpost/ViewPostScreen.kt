package hu.ait.attendancetracker.ui.screen.viewpost

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ViewPostScreen(
    viewPostViewModel: ViewPostViewModel = viewModel(),
    onNavigateWhenSuccess : ()->Unit = {}
) {
    // change this to be post.guests -> the problem is how
    val initialList = mutableListOf<String>()

    var eventTitle by remember { mutableStateOf("") }
    var eventDate by remember { mutableStateOf("") }
    var eventLocation by remember { mutableStateOf("") }
    var guestName by remember { mutableStateOf("") }
    var eventGuests by remember { mutableStateOf(initialList) }

    val context = LocalContext.current


    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = eventTitle,
        )
        Text(
            text = eventDate,
        )
        Text(
            text = eventLocation,
        )
        Text(text = "Guests:",)
        //display guest list


        OutlinedTextField(value = guestName,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Name") },
            onValueChange = {
                guestName = it
            }
        )
        Button(onClick = {
            viewPostViewModel.signUp(guestName)
        }) {
            Text(text = "Sign up")
        }





        when (viewPostViewModel.viewPostUiState) {
            is ViewPostUiState.Init -> {}
            is ViewPostUiState.LoadingPostUpload -> CircularProgressIndicator()
            is ViewPostUiState.PostUploadSuccess -> onNavigateWhenSuccess()
            is ViewPostUiState.ErrorDuringPostUpload -> {
                Text(
                    text = "Error: ${ (viewPostViewModel.viewPostUiState as
                            ViewPostUiState.ErrorDuringPostUpload).error}"
                )
            }
        }

    }
}


