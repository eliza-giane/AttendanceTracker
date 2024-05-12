package hu.ait.attendancetracker.ui.screen.writepost

import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import java.io.File

//@OptIn(ExperimentalPermissionsApi::class)
@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun WritePostScreen(
    writePostViewModel: WritePostViewModel = viewModel(),
    onNavigateWhenSuccess : ()->Unit = {}
) {
    var eventTitle by remember { mutableStateOf("") }
    var eventDate by remember { mutableStateOf("") }
    var eventLocation by remember { mutableStateOf("") }

    val context = LocalContext.current

//    val cameraPermissionState = rememberPermissionState(
//        android.Manifest.permission.CAMERA
//    )
    var hasImage by remember {
        mutableStateOf(false)
    }
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            hasImage = success
        }
    )



    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        OutlinedTextField(value = eventTitle,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Event title") },
            onValueChange = {
                eventTitle = it
            }
        )
        OutlinedTextField(value = eventDate,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Event date") },
            onValueChange = {
                eventDate = it
            }
        )
        OutlinedTextField(value = eventDate,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Event location") },
            onValueChange = {
                eventLocation = it
            }
        )

//        if (cameraPermissionState.status.isGranted) {
//            //if we have the camera permission then show a "Take photo" button
//            Button(onClick = {
//                // this code launches the camera
//                val uri = ComposeFileProvider.getImageUri(context)
//                imageUri = uri
//                cameraLauncher.launch(uri)
//            }) {
//                Text(text = "Take photo")
//            }
//        } else { // if we do not have the Camera permission yet, we need to ask..
//            val permissionText = if (cameraPermissionState.status.shouldShowRationale) {
//                "Please reconsider giving the camera persmission " +
//                        "it is needed if you want to take photo for the message"
//            } else {
//                "Give permission for using photos with items"
//            }
//            Text(text = permissionText)
//            Button(onClick = {
//                // this code pops up a permission request dialog
//                cameraPermissionState.launchPermissionRequest()
//            }) {
//                Text(text = "Request permission")
//            }
//        }


        Button(onClick = {
            if (imageUri == null) {
                writePostViewModel.uploadPost(
                    eventTitle,
                    eventDate
                )
            } else {
                writePostViewModel.uploadPostImage(
                    context.contentResolver,
                    imageUri!!, // this is the image file location locally on the phone
                    eventTitle,
                    eventDate
                )
            }
        }) {
            Text(text = "Create event")
        }


//        if (hasImage && imageUri != null) {
//            AsyncImage(model = imageUri,
//                modifier = Modifier.size(200.dp, 200.dp),
//                contentDescription = "selected image")
//        }


        when (writePostViewModel.writePostUiState) {
            is WritePostUiState.Init -> {}
            is WritePostUiState.LoadingPostUpload -> CircularProgressIndicator()
            is WritePostUiState.PostUploadSuccess -> onNavigateWhenSuccess()
            is WritePostUiState.ErrorDuringPostUpload -> {
                Text(
                    text = "Error: ${ (writePostViewModel.writePostUiState as
                            WritePostUiState.ErrorDuringPostUpload).error}"
                )
            }

            is WritePostUiState.LoadingImageUpload -> CircularProgressIndicator()
            is WritePostUiState.ImageUploadSuccess -> {
                Text(text = "Image uploaded, starting post upload.")
            }
            is WritePostUiState.ErrorDuringImageUpload -> Text(
                text = "${(writePostViewModel.writePostUiState as
                        WritePostUiState.ErrorDuringImageUpload).error}")

        }

    }
}


class ComposeFileProvider : FileProvider(
//    hu.bme.aut.aitforum.R.xml.filepaths
) {
    companion object {
        fun getImageUri(context: Context): Uri {
            val directory = File(context.cacheDir, "images")
            directory.mkdirs()
            val file = File.createTempFile(
                "selected_image_",
                ".jpg",
                directory,
            )
            val authority = context.packageName + ".fileprovider"
            return getUriForFile(
                context,
                authority,
                file,
            )
        }
    }
}

