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
//
//@HiltViewModel
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
//      }
//
//    }

//        viewModelScope.launch {
//            _editableItem.value = if (itemId != -1) {
//                repository.getItemByIdFlow(itemId).first()
//            } else {
//                null
//            }
//        }
//    }
//
//    fun deleteItem(item: ShoppingItem) {
//        viewModelScope.launch {
//            repository.deleteItem(item)
//        }
//    }
//
//    fun deleteAllItems() {
//        viewModelScope.launch {
//            repository.deleteAllItems()
//        }
//    }
//
//    fun searchItems(name: String): Flow<List<ShoppingItem>> {
//        return repository.searchItems(name)
//    }
//
//    fun filterItemsByPrice(minPrice: Float, maxPrice: Float): Flow<List<ShoppingItem>> {
//        return repository.filterItemsByPrice(minPrice, maxPrice)
//    }
//
//    fun filterItemsByCategory(category: String): Flow<List<ShoppingItem>> {
//        return repository.filterItemsByCategory(category)
//    }
//
//    // Total price of all items in the shopping list
//    val totalPrice: Flow<Float> = repository.getTotalPrice()
//
//    fun setEditableItem(item: ShoppingItem?) {
//        _editableItem.value = item
//    }
//
//    fun addItem(item: ShoppingItem) {
//        viewModelScope.launch {
//            repository.insertItem(item)
//        }
//    }
//
//    fun updateItem(item: ShoppingItem) {
//        viewModelScope.launch {
//            repository.updateItem(item)
//        }
//    }
//
//}
