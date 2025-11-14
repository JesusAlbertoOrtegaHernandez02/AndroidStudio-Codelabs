package com.example.taskdone

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskdone.ui.theme.TaskDoneTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskDoneTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ){
                    ComposeTaskCard()

                }
            }
        }
    }
}


@Composable
fun ComposeTaskCard(){
    TaskCard(
        taskSatate = stringResource(R.string.task_completed),
        messageFinish = stringResource(R.string.congratulations),
        imageTaskCompleted = painterResource(R.drawable.ic_task_completed)

    )

}

@Composable
private fun TaskCard(
    taskSatate: String,
    messageFinish: String,
    imageTaskCompleted: Painter,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = imageTaskCompleted, contentDescription = null)
        Text(
            text = taskSatate,
            modifier = modifier.padding(24.dp, 0.dp, 8.dp),
            fontWeight = Bold
        )
        Text(
            text = messageFinish,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskDoneTheme {
        ComposeTaskCard()
    }
}