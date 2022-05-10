package com.example.taskmanagerspecscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
//                    .wrapContentWidth(Alignment.CenterHorizontally)
//                    .wrapContentHeight(Alignment.CenterVertically)
                    .wrapContentSize(Alignment.Center)
            )
            Text(
                text = taskComplete,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 8.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Text(
                text = congrats,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskManagerSpecsComposeTheme {
        TaskStatusText("Android", "woohoo")
    }
}