package com.stealthx.firstquotesapp

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.google.gson.Gson
import com.stealthx.firstquotesapp.models.Quotes
import com.stealthx.firstquotesapp.screens.showQuoteDetails

object DataManager {

    var data = mutableListOf<Quotes>()

    var currentScreen = mutableStateOf(Screens.LISTSCREEN)

    var isDataLoaded = mutableStateOf(false)

    var currentQuote : String? = null
    var currentAuthor : String? = null

    fun loadAssetsFromFile(context: Context){

        try{
            val inputStream = context.resources.openRawResource(R.raw.quotes)
            val size = inputStream.available()   // get the size of the file
            val buffer = ByteArray(size)     // create a buffer
            inputStream.read(buffer)        // read the file into the buffer
            inputStream.close()             // close the file
            val json = String(buffer)
            val gson = Gson()
            data = gson.fromJson(json, Array<Quotes>::class.java).toMutableList()

            isDataLoaded.value = true
        }
        catch (e: Exception){
            Log.e("DataManager", "Error loading data", e)
        }
    }

    fun switchScreens(_quote: String, _author: String){
        if (currentScreen.value == Screens.LISTSCREEN){
            currentQuote = _quote
            currentAuthor = _author
            currentScreen.value = Screens.DETAILSCREEN
        }
    }
}