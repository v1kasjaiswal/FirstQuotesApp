package com.stealthx.firstquotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.stealthx.firstquotesapp.DataManager
import com.stealthx.firstquotesapp.models.Quotes

@Composable
fun showQuotesList(data: List<Quotes>, onClick : () -> Unit) {
    LazyColumn {
        items(data.size) { quote ->
            QuotesResource(
                _quote = data[quote].quote,
                _author = data[quote].author 
            ) {
                onClick()
            }
        }
    }
}
