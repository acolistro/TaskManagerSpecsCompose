package com.example.taskmanagerspecscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskmanagerspecscompose.ui.theme.TaskManagerSpecsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerSpecsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TaskStatusText(stringResource(R.string.task_complete_text), stringResource(R.string.nice_work_text))
                }
            }
        }
    }
}

@Composable
fun TaskStatusText(taskComplete: String, congrats: String) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .wrapContentHeight(Alignment.CenterVertically)
        )
        Text(text = taskComplete)
        Text(text = congrats)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskManagerSpecsComposeTheme {
        TaskStatusText("Android", "woohoo")
    }
}