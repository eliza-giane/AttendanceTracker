package hu.ait.attendancetracker.data

data class Post(
    var uid: String = "",
    var author: String = "",
    var title: String = "",
    var date: String = "",
    var location: String = "",
    var guests: MutableList<String> = mutableListOf()
)

data class PostWithId(
    val postId: String,
    val post: Post
)

fun addGuest(postId: String, guestName: String, posts: MutableList<PostWithId>) {
    val postWithId = posts.find { it.postId == postId }
    postWithId?.post?.guests?.add(guestName)
}