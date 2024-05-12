package hu.ait.attendancetracker.data
//
//import androidx.room.*
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Query
//import hu.ait.data.ShoppingItem
//import kotlinx.coroutines.flow.Flow
//
//
//@Dao
//interface ShoppingItemDao {
//
//    @Query("SELECT * FROM shopping_items")
//    fun getAllItems(): Flow<List<Post>>
//
//    @Insert
//    suspend fun insertItem(item: Post)
//
//    @Delete
//    suspend fun deleteItem(item: Post)
//
//    @Update
//    suspend fun updateItem(item: Post)
//
//    @Query("DELETE FROM shopping_items")
//    suspend fun deleteAllItems()
//
//    // Calculate the total price of all items
////    @Query("SELECT SUM(price) FROM shopping_items")
////    fun getTotalPrice(): Flow<Float>
//
////    @Query("SELECT * FROM shopping_items WHERE id = :id")
////    fun getItemByIdFlow(id: Int): Flow<Post>
////
////    @Query("SELECT * FROM shopping_items WHERE title LIKE :title")
////    fun searchItems(name: String): Flow<List<Post>>
////
////    @Query("SELECT * FROM shopping_items WHERE price BETWEEN :minPrice AND :maxPrice")
////    fun filterItemsByPrice(minPrice: Float, maxPrice: Float): Flow<List<Post>>
////
////    @Query("SELECT * FROM shopping_items WHERE location = :location")
////    fun filterItemsByCategory(category: String): Flow<List<Post>>
//}
