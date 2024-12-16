package com.example.githubachievments

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubachievments.ui.theme.GithubAchievmentsTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GithubAchievmentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                    {
                        Greeting(
                            name = "Marcin Hałaczkiewicz",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp)
                        )
                        RecentActivitiesScreen()
                    }
                }
            }
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.man_person_icon),
            contentDescription = stringResource(id = R.string.man_content_description),
            modifier = Modifier
                .size(70.dp)
                .padding(vertical = 5.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Git statistics",
                color = Color(0xFF7D57C1),
                fontSize = 15.sp
            )
        }
    }
}
@Composable
fun RecentActivitiesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Recent Activities",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ActivityRow(iconId = R.drawable.commit, title = "Committed changes", count = "22")
        ActivityRow(iconId = R.drawable.comment, title = "Comment count", count = "15")
        ActivityRow(iconId = R.drawable.merge, title = "Merged pull requests", count = "8")
        ActivityRow(iconId = R.drawable.closed, title = "Closed pull requests", count = "3")

        Spacer(modifier = Modifier.weight(1f))

        val context = LocalContext.current
        Button(
            onClick = { Toast.makeText(context, "Well done!", Toast.LENGTH_SHORT).show() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7D57C1)),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Display message", color = Color.White)
        }
    }
}
@Composable
fun ActivityRow(iconId: Int, title: String, count: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color(0xFF7D57C1),
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = count,
            fontSize = 16.sp,
            color = Color(0xFF7D57C1),
            fontWeight = FontWeight.Bold
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GithubAchievmentsTheme {
        Greeting("Marcin Hałaczkiewicz")
    }
}
@Preview(showBackground = true)
@Composable
fun ActivityPreview() {
    GithubAchievmentsTheme {
        RecentActivitiesScreen()
    }
}