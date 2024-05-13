package hu.ait.attendancetracker.ui.screen.messages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.auth.FirebaseAuth
import hu.ait.attendancetracker.data.Post
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessagesScreen(
    messagesViewModel: MessagesViewModel = viewModel(),
    onWritePost: ()->Unit = {},
//    onViewPost: ()->Unit = {},
//    onSignUp: ()->Unit = {}
) {
    val postListState = messagesViewModel.postsList().collectAsState(
        initial = MessagesUIState.Init)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EVENTS") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                actions = {
                    IconButton(onClick = { /* Show app usage info */ }) {
                        Icon(Icons.Filled.Info, contentDescription = "Info")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onWritePost,
                containerColor = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(16.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add",
                    tint = Color.White,
                )
            }
        }
    ) { contentPadding ->
        // Screen content
        Column(modifier = Modifier.padding(contentPadding)) {
//            Button(
//                onClick = onSignUp,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = MaterialTheme.colorScheme.primary
//                ),
//                shape = RoundedCornerShape(16.dp)
//            ) {
//                Text("Sign Up for Events", color = Color.White)
//            }

            when (val uiState = postListState.value) {
                is MessagesUIState.Init -> Text("Initializing...")
                is MessagesUIState.Loading -> CircularProgressIndicator()
                is MessagesUIState.Success -> LazyColumn {
                    items(uiState.postList) { post ->
                        PostCard(post = post.post,
                            onRemoveItem = { messagesViewModel.deletePost(post.postId) },
                            currentUserId = FirebaseAuth.getInstance().uid!!,
//                            onViewPost = onViewPost
                        )
                    }
                }
                is MessagesUIState.Error -> Text("An error occurred!")
            }
        }
    }
}

@Composable
fun PostCard(
    post: Post,
    onRemoveItem: () -> Unit = {},
    currentUserId: String = "",
    onUpdateGuests: (List<String>) -> Unit = {} // Callback to update the guest list in the main data model
) {
    var textState by remember { mutableStateOf("") }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier.padding(5.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = post.title)
                    Text(text = post.date)
                    Text(text = post.location)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
//                    IconButton(
//                        onClick = onViewPost
//                    ) {
//                        Icon(Icons.Filled.Info, contentDescription = "Info")
//                    }

                    if (currentUserId == post.uid) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Delete",
                            modifier = Modifier.clickable(onClick = onRemoveItem),
                            tint = Color.Red
                        )
                    }
                }
            }

            // Guests list with checkboxes
            Text(text = "Guests:")
            LazyColumn {
                items(post.guests.size) { index ->
                    val guest = post.guests[index]
                    var isChecked by remember { mutableStateOf(false) }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it }
                        )
                        Text(text = guest, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }

            // Input and button for adding new guests
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                TextField(
                    value = textState,
                    onValueChange = { textState = it },
                    label = { Text("Enter guest name") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        if (textState.isNotBlank()) {
                            onUpdateGuests(post.guests + textState)
                            textState = "" // Reset the input field after adding
                        }
                    }),
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = {
                        if (textState.isNotBlank()) {
                            onUpdateGuests(post.guests + textState)
                            textState = "" // Reset the input field after adding
                        }
                    },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text("Add")
                }
            }
        }
    }
}