package hu.ait.attendancetracker.ui.screen
//
//// used to be ShoppingListScreen
//import androidx.compose.animation.animateContentSize
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material.icons.outlined.ArrowDropDown
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material.icons.filled.KeyboardArrowDown
//import androidx.compose.material.icons.filled.KeyboardArrowUp
//import androidx.hilt.navigation.compose.hiltViewModel
//import hu.ait.attendancetracker.data.Post
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainScreen(
//    viewModel: MainViewModel = hiltViewModel(),
//    onItemClick: (Int) -> Unit = {},
//    onAddItem: () -> Unit = {}
//) {
//    var showDialog by remember { mutableStateOf(false) }
//    var showError by remember { mutableStateOf(false) }
//    var errorMessage by remember { mutableStateOf("") }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "Events")
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer
//                ),
//                actions = {
//                    IconButton(onClick = {
//                        showDialog = true
//                    }) {
//                        Icon(Icons.Filled.Add, null)
//                    }
//
//                    IconButton(onClick = {
//                        viewModel.deleteAllEvents()
//                    }) {
//                        Icon(Icons.Filled.Delete, null)
//                    }
////                    IconButton(onClick = {
////                        //
////                    }) {
////                        Icon(Icons.Filled.Info, null)
////                    }
//                }
//            )
//        },
//        content = {
//            Column(modifier = Modifier.padding(it)) {
//                if (showDialog) {
//                    AddEventDialog(
//                        onDismissRequest = { showDialog = false }
//                        onSubmit={ title, date, location ->
//                           viewModel.addEvent(title, date,location)
//                           showDialog= false
//                  }
//            )
//    }
//                           
//       if(showError){
//             Text(text=errorMessage,color=Color.Red)
//  }
//  EventListContent(
//   modifier= Modifier.padding(it),
//   viewModel= viewModel
//   )                            
//
//@Composable
//fun EventListContent(
//    modifier: Modifier,
//    mainViewModel: MainViewModel
//) {
//    val eventList by viewModel.allEvents.collectAsState(initial=emptyList())
//    
//   if (eventList.isEmpty()){
//       Text(text="No events")
// }else {
//        LazyColumn(modifier=modifier){
//             items(eventList){ event ->
//                EventCard(
//                   event=event,
//                   onRemoveEvent= { viewModel.deleteEvent(event.id) }
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun EventCard(
//    event:Event,
//    onRemoveEvent () -> Unit 
//  ){
//   Card(
//       modifier= Modifier.padding(5.dp),
//       shape= RoundedCornerShape(8.dp),
//       elevation= 4.dp
//){
//         ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(event.title, style = MaterialTheme.typography.h6)
//          Spacer(Modifier.height(4.dp))
//             Text(event.date, style = MaterialTheme.typography.body2)
//         Spacer(Modifier.height(4.dp))
//            Text(event.location, style = MaterialTheme.typography.body2)
//            IconButton(onClick = onRemoveEvent) {
//                Icon(Icons.Filled.Delete, contentDescription = "Delete Event")
//            }
//        }
//    }
//}
//@Composable
//fun AddEventDialog(
//    onDismissRequest: () -> Unit,
//    onSubmit: (String, String, String) -> Unit
//) {
//    var title by remember { mutableStateOf("") }
//    var date by remember { mutableStateOf("") }
//    var location by remember { mutableStateOf("") }
//
//    AlertDialog(
//        onDismissRequest = { onDismissRequest() },
//        title = { Text("Add New Event") },
//        text = {
//            Column {
//                TextField(
//                    value = title,
//                    onValueChange = { title = it },
//                    label = { Text("Title") }
//                )
//                TextField(
//                    value = date,
//                    onValueChange = { date = it },
//                    label = { Text("Date") }
//                )
//                TextField(
//                    value = location,
//                    onValueChange = { location = it },
//                    label = { Text("Location") }
//                )
//            }
//        },
//        confirmButton = {
//            Button(
//                onClick = {
//                    if (title.isNotEmpty() && date.isNotEmpty() && location.isNotEmpty()) {
//                        onSubmit(title, date, location)
//                        title = ""
//                        date = ""
//                        location = ""
//                        onDismissRequest()
//                    } else {
//                        errorMessage = "All fields must be filled"
//                        showError = true
//                    }
//                }
//            ) { Text("Add") }
//        },
//        dismissButton = {
//            Button(onClick = { onDismissRequest() }) { Text("Cancel") }
//        }
//    )
//}
//
