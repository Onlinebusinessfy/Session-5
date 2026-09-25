package com.samuel.session5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samuel.session5.ui.theme.Session5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserProfileScreen()
        }
    }
}

@Composable
fun UserProfileScreen(){
    var name by remember { mutableStateOf("John Smith") }
    var age by remember { mutableIntStateOf(30) }
    val birthday = "2005/07/21"
    val address by remember {mutableStateOf("123 Example St")}
    var username by remember {mutableStateOf("@smith_j")}
    var like by remember { mutableIntStateOf(0) }
    val isVerified = true

    // CHALLENGE 1
    //println("===CHALLENGE 3===")
    val friends = remember { mutableListOf("Samuel", "Christian", "Esteban", "Alejandro", "Alan") }

    Surface{
        ProfileContent(
            name,
            age,
            birthday,
            address,
            username,
            likesCount = like,
            isVerified,
            onLike = {like ++},
            onChangeUsername = { username = "@newUser123"}
        )
    }

}

@Composable
fun ProfileContent(
    name: String,
    age: Int,
    birthday: String,
    address: String,
    username: String,
    likesCount: Int,
    isVerified: Boolean,
    onLike: () -> Unit,
    onChangeUsername: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "User Profile",
            modifier = Modifier.padding(30.dp))
        Text(text = "Name: $name",
            modifier = Modifier.padding(5.dp))
        Text(text = "Age: $age",
            modifier = Modifier.padding(5.dp))
        Text(text = "Birthday: $birthday",
            modifier = Modifier.padding(5.dp))
        Text(text = "Address: $address",
            modifier = Modifier.padding(5.dp))
        Text(text = "Username: $username",
            modifier = Modifier.padding(5.dp))
        Text(text = "Likes: $likesCount",
            modifier = Modifier.padding(5.dp))
        Text(text = "Verified: ${if (isVerified) "Yes" else "No"}")

        Button(onClick = onLike) {
            Text("Like")
        }

        Button(onClick = onChangeUsername) {
            Text("Change Username")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserProfile() {
    UserProfileScreen()
}
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Column(modifier = Modifier.padding(50.dp)){
//        Text("This is the First Line")
//        Text("This is the second line")
//    }
//    Text(
//        text = "Hello $name",
//        modifier = Modifier.padding(150.dp)
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Session5Theme {
//        Greeting("Android")
//    }
//}