package com.stealthx.firstquotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.stealthx.firstquotesapp.screens.QuotesAppBar
import com.stealthx.firstquotesapp.screens.loadingScreen
import com.stealthx.firstquotesapp.screens.showQuoteDetails
import com.stealthx.firstquotesapp.screens.showQuotesList
import com.stealthx.firstquotesapp.ui.theme.FirstQuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            FirstQuotesAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Column {
        QuotesAppBar()
        if (DataManager.isDataLoaded.value){ // States are Thread Safe
            if (DataManager.currentScreen.value == Screens.LISTSCREEN){
                showQuotesList(data = DataManager.data)
            }
            else{
                var _quote = DataManager.currentQuote!!
                var _author = DataManager.currentAuthor!!

                DataManager.switchScreens(_quote,_author)

                showQuoteDetails(_quote = _quote, _author = _author)
            }
        }
        else{
            loadingScreen()
        }
    }
}


enum class Screens{
    LISTSCREEN,
    DETAILSCREEN
}

