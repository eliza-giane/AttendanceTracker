package hu.ait.attendancetracker.ui.screen
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import hu.ait.attendancetracker.data.Post
//
//@Composable
//fun AddEditEventScreen(
//    viewModel: EventViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
//) {
//
//    val navController = androidx.navigation.compose.rememberNavController()
//    val eventId = navController.previousBackStackEntry?.arguments?.getInt("eventId")
//
//    val eventPost by viewModel.editableEventPost.collectAsState()
//
//    // Form fields state
//    var title by rememberSaveable { mutableStateOf(eventPost?.title ?: "") }
//    var description by rememberSaveable { mutableStateOf(eventPost?.description ?: "") }
//    var date by rememberSaveable { mutableStateOf(eventPost?.date ?: "") }
//    var location by rememberSaveable { mutableStateOf(eventPost?.location ?: "") }
//    var showError by remember { mutableStateOf(false) }
//    var errorMessage by remember { mutableStateOf("") }
//
//    // Effect to load the item when itemId is not null
//    LaunchedEffect(key1 = eventId) {
//        eventId?.let {
//            viewModel.loadEventById(it)
//        }
//    }
//
//    // ... existing UI code ...
//
//    // Button to save or update an item
//    Button(
//        onClick = {
//            if (title.isBlank() || description.isBlank() || price.isBlank() || location.isBlank()) {
//                errorMessage = "Please fill in all fields."
//                showError = true
//            } else {
//                try {
//                    val priceValue = price.toDouble()
//                    if (eventId == null) {
//                        // Adding a new item
//                        val newEvent = EventPost(
//                            title = title,
//                            date = date,
//                            location = location
//                        )
//                        viewModel.addEvent(newEvent)
//                    } else {
//                        // Updating an existing item
//                        val updateEvent = eventPost!!.copy(
//                            tile = title,
//                            description = description,
//                            date = date,
//                            location = location
//                        )
//                        viewModel.updateEvent(updateEvent)
//                    }
//                    navController.popBackStack()
//                } catch (e: NumberFormatException) {
//                    errorMessage = "Please enter a valid price."
//                    showError = true
//                }
//            }
//        },
//        modifier = Modifier.padding(top = 16.dp)
//    ) {
//        Text("Save")
//    }
//
//    if (showError) {
//        Text(
//            text = errorMessage,
//            color = Color.Red,
//            modifier = Modifier.padding(top = 8.dp)
//        )
//    }
//}
