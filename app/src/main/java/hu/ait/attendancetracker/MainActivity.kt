package hu.ait.attendancetracker

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hu.ait.attendancetracker.ui.navigation.Screen
import hu.ait.attendancetracker.ui.screen.login.LoginScreen
import hu.ait.attendancetracker.ui.screen.messages.MessagesScreen
import hu.ait.attendancetracker.ui.screen.writepost.WritePostScreen
import hu.ait.attendancetracker.ui.theme.AttendanceTrackerTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttendanceTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Messages.route)
                }
            )
        }
        composable(Screen.Messages.route) {
            MessagesScreen(
                onWritePost = {
                    navController.navigate(Screen.WritePost.route)
                }
//                onViewPost = {
//                    navController.navigate(Screen.ViewPost.route)
//                }
            )
        }
        composable(Screen.WritePost.route) {
            WritePostScreen(
                onNavigateWhenSuccess = {
                    navController.navigate(Screen.Messages.route)
                }
            )
        }
    }
}
