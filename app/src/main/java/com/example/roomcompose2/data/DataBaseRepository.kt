package com.example.roomcompose2.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.example.roomcompose2.domain.NoteModel

interface DataBaseRepository {

    suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit, onFail: () -> Unit)


    suspend fun deleteNote(noteModel: NoteModel)


    fun getAllNote(): LiveData<List<NoteModel>>


    suspend fun editNote(noteModel: NoteModel)

    fun getNoteByID(id: Long, onSuccess: () -> Unit, onFail: () -> Unit): LiveData<NoteModel>

    fun findNoteByTheme(noteTheme: String): LiveData<List<NoteModel>>
}