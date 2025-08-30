package com.example.foodapp.ui.symptoms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SymptomsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Input your symptoms!"
    }
    val text: LiveData<String> = _text
}