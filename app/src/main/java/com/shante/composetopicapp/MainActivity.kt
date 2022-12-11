package com.shante.composetopicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shante.composetopicapp.data.DataSource
import com.shante.composetopicapp.models.Topic
import com.shante.composetopicapp.ui.theme.ComposeTopicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTopicAppTheme {
                TopicApp()
            }
        }
    }
}

@Composable
fun TopicApp() {
    ComposeTopicAppTheme {
        TopicList(topics = DataSource.topics)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicList(topics: List<Topic>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        items(topics.size) { index ->
            TopicCard(topic = topics[index])
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        elevation = 4.dp
    ) {
        Row {
            Image(
                painter = painterResource(id = topic.topicImageResourceId),
                contentDescription = stringResource(id = topic.topicStringResourceId),
                modifier = modifier
                    .size(width = 68.dp, height = 68.dp)
            )
            TopicDescription(topic = topic)
        }
    }
}

@Composable
fun TopicDescription(topic: Topic) {
    Column {
        Text(
            text = stringResource(id = topic.topicStringResourceId),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
            style = MaterialTheme.typography.caption
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextWithIconOnLeft(text = topic.availableCourses.toString())
    }
}

@Composable
fun TextWithIconOnLeft(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.ic_grain),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(12.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTopicAppTheme {
        TopicApp()
    }
}