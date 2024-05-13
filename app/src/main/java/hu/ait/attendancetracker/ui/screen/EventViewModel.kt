package hu.ait.attendancetracker.ui.screen
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import dagger.hilt.android.lifecycle.HiltViewModel
//
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.launch
//import javax.inject.Inject

//class EventViewModel: ViewModel(){
//    private val db = FirebaseFirestore.getInstance()
//    private val storage= FirebaseStorage.getInstance()
//    
//    private val _UiState= MutableStateFlow<EventUiState>(EventUiState.Empty)
//    val uiState: StateFlow<EventUiState> = _uiState

//
//
//    fun addEvent(title:String, date:String, location: String, imageUri: Uri?){
//    _uiState.value= EventUiState.loading
//    viewModelScope.launch{
//        try{
//         val imageUrl= imageUri?.let{ uploadImageToStorage(it)}
//       val event = Event(title, date, location, imageUrl)
//              db.collection("events").add(event).await()
//                _uiState.value = EventUiState.Success
//           } catch (e: Exception) {
//              _uiState.value = EventUiState.Error(e.message ?: "Unknown error")
//           }
        }
//  }

//       
//    private suspend fun uploadImageToStorage(imageUri: Uri): String {
//        val imageRef = storage.reference.child("event_images/${System.currentTimeMillis()}.jpg")
 //       val uploadTask = imageRef.putFile(imageUri).await()
//        return imageRef.downloadUrl.await().toString()
//    }
//
//  fun fetchEvents(){
//   _uiState.value=EventUiState.loading
//  viewModelScope.launch{
//    val snapshot = db.collection("events").get().await()
//              val events = snapshot.toObjects(Event::class.java)
//                _uiState.value = EventUiState.EventsLoaded(events)
//          } catch (e: Exception) {
//              _uiState.value = EventUiState.Error(e.message ?: "Unknown error")
//          }
//       }
 //   }
//   }

//data class Event(
//    val title: String,
 //   val date: String,
//    val location: String,
//    val imageUrl: String? = null
//   )

//   sealed class EventUiState {
 //    object Empty : EventUiState()
 //   object Loading : EventUiState()
 //    data class Success(val event: Event? = null) : EventUiState()
 //   data class EventsLoaded(val events: List<Event>) : EventUiState()
 //   data class Error(val message: String) : EventUiState()
//}


