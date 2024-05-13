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
//interface EventDao {
//
//    @Query("SELECT * FROM events")
//    fun getAllEvents(): Flow<List<Event>>
//
//    @Insert
//    suspend fun insertEvent(item: Event)
//
//    @Delete
////    suspend fun deleteEvent(item: Event)
///
////    @Update
////    suspend fun updateEvent(item: Evend)
////
////   @Query("DELETE FROM events")
////    suspend fun deleteAllEvents()

////    @Query("SELECT * FROM events WHERE id = :id")
////    fun getEventByIdFlow(id: Int): Flow<Event>
////
////    @Query("SELECT * FROM events WHERE name LIKE :name")
////    fun searchEventsByName(name: String): Flow<List<Event>>
////
////    @Query("SELECT * FROM events WHERE date BETWEEN :startDate AND :endDate")
////    fun filterEventsByDate(startDate: LocalDateTime, endDate: LocalDateTime): Flow<List<Event>>
////
////    @Query("SELECT * FROM events WHERE location LIKE :location")
////    fun filterEventsbyLocation(category: Location): Flow<List<Event>>
//}
