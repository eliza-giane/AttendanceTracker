package hu.ait.attendancetracker.data
//
//import android.content.Context
//import androidx.lifecycle.LiveData
//import hu.ait.data.ShoppingItem
//import hu.ait.data.ShoppingItemDao
//import kotlinx.coroutines.flow.Flow
//import javax.inject.Inject
//
//class EventPostRepository @Inject constructor(
//    private val eventPostDao: EventPostDao
//) {
//
//    fun getAllEventPosts(): Flow<List<EventPost>> {
//        return eventPostDao.getAllEventPosts()
//    }
//
//
//    suspend fun insertEventPost(eventPost: EventPost) {
//        eventPostDao.insertEventPost(eventPost)
//    }
//
//    suspend fun deleteEventPost(eventPost: EventPost) {
//        eventPostDao.deleteEventPost(eventPost)
//    }
//
//    suspend fun updateEventPost(eventPost: EventPost) {
//        eventPostDao.updateEventPost(eventPost)
//    }
//
//    suspend fun deleteAllEventPosts() {
//        eventPostDao.deleteAllEventPosts()
//    }
//
//    fun getEventPostById(id:Int): Flow<EventPost> {
//        return eventPostDao.getEventPostById(id)
//    }
//
//    fun searchEventPostsByName(name: String): Flow<List<EventPost>> {
//        return eventPostDao.searchEventPostsByName(name)
//    }
//
//    fun filterEventPostsByDate(startDate: LocalDateTime, endDate: LocalDateTime): Flow<List<EventPost>> {
//        return eventPostDao.filterEventPostsByDate(startDate, endDate)
//    }
//
//    fun filterEventPostsByLocation(location: String): Flow<List<EventPost>> {
//        return eventPostDao.filterEventPostsByLocation(location)
//    }
//}
