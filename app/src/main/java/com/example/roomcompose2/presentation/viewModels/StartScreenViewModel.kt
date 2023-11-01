package com.example.roomcompose2.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.roomcompose2.data.NoteRepository
import com.example.roomcompose2.domain.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StartScreenViewModel(private val repository: NoteRepository) : ViewModel() {

    //private val _listNote = MutableLiveData<List<NoteModel>>()
    val listNote: LiveData<List<NoteModel>> = repository.getAllNote()

    fun addNote(noteModel: NoteModel, onSuccessAddNote: () -> Unit, onFailAddNote: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNote(noteModel, onFail = {
                onFailAddNote()
                Log.d("insertNoteTag", "fail")
            },
                onSuccess = {
                    onSuccessAddNote()
                    Log.d("insertNoteTag", "success")
                })
        }
    }

    fun getNoteById(id: Long, onSuccess: () -> Unit, onFail: () -> Unit): LiveData<NoteModel> {
        return repository.getNoteByID(
            id,
            onFail = {
                onFail()
                Log.d("getNoteByIdTag", "fail")
            },
            onSuccess = {
                onSuccess()
                Log.d("getNoteByIdTag", "success")
            }
        )
    }

}

class ViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StartScreenViewModel::class.java)) {
            return StartScreenViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}