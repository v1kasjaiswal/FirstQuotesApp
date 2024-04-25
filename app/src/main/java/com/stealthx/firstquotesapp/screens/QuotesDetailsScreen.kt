package com.stealthx.firstquotesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun showQuoteDetails() {
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
    ) {

    }
}

@Preview(showSystemUi = true)
@Composable
private fun ShowPreview() {
//    Column {
//        QuotesAppBar()
//        showQuotesList()
//    }
    showQuoteDetails()
}

