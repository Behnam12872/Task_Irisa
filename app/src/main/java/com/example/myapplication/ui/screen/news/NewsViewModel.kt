package com.example.myapplication.ui.screen.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.DataError
import com.example.myapplication.data.model.DataResult
import com.example.myapplication.data.model.NewsResponse
import com.example.myapplication.data.model.ViewResult
import com.example.myapplication.data.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    private val _newsState = MutableStateFlow<ViewResult<NewsResponse>>(ViewResult.Loading)
    val newsState: StateFlow<ViewResult<NewsResponse>> = _newsState

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            newsRepository.getNews()
                .onEach { result ->
                    when (result) {
                        is DataResult.Error -> _newsState.value = ViewResult.Error(result.error)
                        is DataResult.Success -> _newsState.value = ViewResult.Success(result.data)
                    }
                }
                .catch {
                    _newsState.value = ViewResult.Error(DataError.UNKNOWN)
                }
                .launchIn(this)
        }
    }
}