package com.stealthx.firstquotesapp.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stealthx.firstquotesapp.R

@Composable
fun QuotesAppBar() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(.07f)
            .background(color = Color(0xFFEEEEEE), shape = RectangleShape)
    ) {
        Text(
            text = "#FirstQuotesApp",
            style = MaterialTheme.typography.titleLarge,
            fontFamily = FontFamily(Font(R.font.urania)),
            modifier = Modifier.padding(start = 15.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Vikas Jaiswal",
            modifier = Modifier
                .padding(9.dp)
                .clip(CircleShape)
                .align(Alignment.CenterEnd)

        )
    }
}

@Composable
fun QuaotesResource(_quote: String, _author: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEEEEEE),
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 15.dp, vertical = 8.dp)
    ) {
        Row {

            Image(
                painter = painterResource(id = R.drawable.quotation),
                contentDescription = "Quotation",
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 15.dp)
            )

            Spacer(modifier = Modifier.padding(horizontal = 10.dp))

            quotesAndAuthors(_quote, _author)
        }
    }
}

@Composable
private fun quotesAndAuthors(_quote: String, _author :String) {
    Column {
        Text(
            text = _quote,
            style = MaterialTheme.typography.titleMedium,
            fontFamily = FontFamily(Font(R.font.urania)),
            modifier = Modifier.padding(top = 10.dp, end = 15.dp)
        )

        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(top = 5.dp, end = 15.dp)
        )

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        Text(
            text = _author,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.urania)),
            modifier = Modifier.padding(bottom = 10.dp, end = 15.dp)
        )
    }
}

data class Quotes(val _quote: String, val _author: String)

fun quotesList(): MutableList<Quotes>{
    var quotesList = mutableListOf<Quotes>()

    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))
    quotesList.add(Quotes("This is my Favourite and Motivational Quote", "This is my Leader"))

    return quotesList
}

@Composable
fun showQuotesList() {
    LazyColumn {
        items(quotesList().size){ quote ->
            QuaotesResource(_quote = quotesList()[quote]._quote, _author = quotesList()[quote]._author)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun showPreview() {

}
