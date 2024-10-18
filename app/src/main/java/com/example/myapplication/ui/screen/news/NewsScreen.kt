package com.example.myapplication.ui.screen.news

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.model.DataError
import com.example.myapplication.data.model.NewsResponse
import com.example.myapplication.data.model.ViewResult
import com.example.myapplication.ui.theme.Black
import com.example.myapplication.ui.theme.Gray1
import com.example.myapplication.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    newsViewModel: NewsViewModel = koinViewModel(),
) {
    val news by newsViewModel.newsState.collectAsState()
    val context = LocalContext.current
    when (news) {
        is ViewResult.Loading -> {
            Column(
                modifier = Modifier
                    .background(Gray1)
                    .fillMaxSize()
            ) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        }

        is ViewResult.Error -> {
            val error = (news as ViewResult.Error).exception
            when (error) {
                DataError.UNKNOWN -> {
                    Column(
                        modifier = Modifier
                            .background(Gray1)
                            .fillMaxSize()
                    ) {
                        Toast.makeText(context, "NetWork Error", Toast.LENGTH_SHORT).show()
                    }
                }

                DataError.DATA_NOT_FOUND -> {
                    Column(
                        modifier = Modifier
                            .background(Gray1)
                            .fillMaxSize()
                    ) {
                        Toast.makeText(context, "Get Data Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        is ViewResult.Success -> {
            val data = (news as ViewResult.Success<NewsResponse>).data.Data
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        modifier = Modifier
                            .shadow(
                                elevation = 1.dp,
                            ),
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Gray1,
                        ),
                        title = {
                            Text(text = "News", color = Black)
                        },
                    )
                },
                containerColor = Gray1,
                content = { innerPadding ->
                    Column(
                        modifier = Modifier
                            .background(Gray1)
                            .padding(innerPadding)
                    ) {

                        LazyColumn(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            items(data) { data ->

                                Card(
                                    modifier = Modifier.padding(5.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = White
                                    ),
                                    elevation = CardDefaults.elevatedCardElevation(
                                        defaultElevation = 5.dp
                                    )
                                ) {
                                    Text(
                                        modifier = Modifier.padding(horizontal = 10.dp),
                                        text = data.title,
                                        fontWeight = FontWeight.Bold,
                                        color = Black
                                    )
                                    HorizontalDivider(modifier = Modifier.padding(horizontal = 10.dp))

                                    Text(
                                        modifier = Modifier.padding(5.dp),
                                        color = Color.DarkGray,
                                        text = data.body
                                    )
                                    HorizontalDivider(modifier = Modifier.padding(horizontal = 10.dp))

                                    Text(
                                        modifier = Modifier.padding(5.dp),
                                        color = Color.DarkGray,
                                        text = data.url
                                    )
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}