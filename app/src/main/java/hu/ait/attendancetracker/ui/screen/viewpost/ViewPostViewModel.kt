package hu.ait.attendancetracker.ui.screen.viewpost

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import hu.ait.attendancetracker.data.Post

class ViewPostViewModel : ViewModel() {

    var viewPostUiState: ViewPostUiState by mutableStateOf(ViewPostUiState.Init)

    fun signUp(
        guest: String,
        postKey: String
    ){
//        FirebaseFirestore.getInstance().collection(
//            "posts"
//        ).get(postKey)

        // add to the post's guest list
    }
//    fun uploadPost(
//        eventTitle: String, eventDate: String, eventLocation: String
//    ) {
//        viewPostUiState = ViewPostUiState.LoadingPostUpload
//        val newPost = Post(
//            FirebaseAuth.getInstance().uid!!,
//            FirebaseAuth.getInstance().currentUser?.email!!,
//            eventTitle,
//            eventDate,
//            eventLocation
//        )
//        val postsCollection = FirebaseFirestore.getInstance().collection(
//            "posts")
//        postsCollection.add(newPost)
//            .addOnSuccessListener{
//                viewPostUiState = ViewPostUiState.PostUploadSuccess
//            }
//            .addOnFailureListener{
//                viewPostUiState = ViewPostUiState.ErrorDuringPostUpload(
//                    "Post upload failed")
//            }
//    }
}

sealed interface ViewPostUiState {
    object Init : ViewPostUiState
    object LoadingPostUpload : ViewPostUiState
    object PostUploadSuccess : ViewPostUiState
    data class ErrorDuringPostUpload(val error: String?) : ViewPostUiState


}