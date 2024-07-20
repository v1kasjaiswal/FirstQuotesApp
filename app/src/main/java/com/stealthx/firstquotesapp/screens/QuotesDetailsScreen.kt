package com.stealthx.firstquotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stealthx.firstquotesapp.DataManager
import com.stealthx.firstquotesapp.R
import com.stealthx.firstquotesapp.Screens
import com.stealthx.firstquotesapp.models.Quotes


@Composable
fun showQuoteDetails(_quote: String, _author: String) {

    BackHandler {
        DataManager.currentScreen.value = Screens.LISTSCREEN
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    listOf(
                        Color.White,
                        Color(0XFFEEEEEE)
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier
                .fillMaxWidth(.8f)
        ) {
            Column(
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.quotation),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(top = 20.dp, start = 20.dp)
                    )

                    Spacer(modifier = Modifier.padding(horizontal = 20.dp))

                    Text(
                        text = "#FirstQuotesApp",
                        style = MaterialTheme.typography.titleLarge,
                        fontFamily = FontFamily(Font(R.font.urania)),
                        modifier = Modifier.padding(top= 15.dp)
                    )
                }

                quoteDetails(_quote, _author)
            }
        }
    }

}

@Composable
private fun quoteDetails(_quote: String, _author: String) {
    Text(
        text = _quote,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.urania)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp)
    )

    Text(
        text = "- $_author",
        fontFamily = FontFamily(Font(R.font.urania)),
        fontSize = 18.sp,
        modifier = Modifier
            .padding(bottom = 10.dp, end = 20.dp)
            .fillMaxWidth()
            .wrapContentWidth(Alignment.End)
    )
}