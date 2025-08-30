package com.example.foodapp.ui.analysis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnalysisViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "These are your results: "
    }
    val text: LiveData<String> = _text
}