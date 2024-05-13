package hu.ait.attendancetracker.data
//
//import androidx.room.*
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Query
//import kotlinx.coroutines.flow.Flow
//
//
//@Dao
//interface EventPostDao {
//
//    @Query("SELECT * FROM event_posts")
//    fun getAllEventsPost(): Flow<List<EventPost>>
//
//    @Insert
//    suspend fun insertEventPost(eventPost: EventPost)
//
//    @Delete
////    suspend fun deleteEventPost(eventPost: EventPost)
///
////    @Update
////    suspend fun updateEventPost(eventPost: EventPost)
////
////   @Query("DELETE FROM event_posts")
////    suspend fun deleteAllEventsPosts()

////    @Query("SELECT * FROM event_posts WHERE id = :id")
////    fun getEventPostById(id: Int): Flow<EventPost>
////
////    @Query("SELECT * FROM event_posts WHERE name LIKE :name")
////    fun searchEventPostsByName(name: String): Flow<List<EventPost>>
////
////    @Query("SELECT * FROM event_posts WHERE date BETWEEN :startDate AND :endDate")
////    fun filterEventPostsByDate(startDate: LocalDateTime, endDate: LocalDateTime): Flow<List<EventPost>>
////
////    @Query("SELECT * FROM event_posts WHERE location LIKE :location")
////    fun filterEventPostssbyLocation(category: Location): Flow<List<EventPost>>
//}
