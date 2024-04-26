package com.stealthx.firstquotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
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
fun loadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Brush.linearGradient(listOf(
                Color.White,
                Color.Cyan
            ))),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Loading . . .",
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.urania))
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun showPreview() {
//    loadingScreen()
}