package hu.ait.attendancetracker.data

data class Post(
    var uid: String = "",
    var author: String = "",
    var title: String = "",
    var date: String = "",
    var location: String = "",
//    var guests: List<String> = List<String>("")
)

data class PostWithId(
    val postId: String,
    val post: Post
)