package com.example.roomcompose2.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomcompose2.data.NoteRepository

class DetailsScreenViewModel(private val repository: NoteRepository) :ViewModel(){



}

//class ViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(NoteRepository::class.java)) {
//            return DetailsScreenViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//
//}