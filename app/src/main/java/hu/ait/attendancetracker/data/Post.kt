package hu.ait.attendancetracker.data

data class Post(
    var uid: String = "",
    var author: String = "",
    var title: String = "",
    var date: String = "",
    var location: String = "",
    var guests: MutableList<String> = mutableListOf()
) {
    fun addGuest(guestName: String) {
        this.guests.add(guestName)
    }
}

data class PostWithId(
    val postId: String,
    val post: Post
)

