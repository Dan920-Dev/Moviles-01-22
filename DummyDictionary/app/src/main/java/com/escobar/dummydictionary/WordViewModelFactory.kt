package com.escobar.dummydictionary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.escobar.dummydictionary.repository.DictionaryRepository

class WordViewModelFactory(private val repository: DictionaryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }


}