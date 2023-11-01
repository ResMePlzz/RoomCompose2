package com.example.roomcompose2.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.roomcompose2.domain.NoteModel


class NoteRepository(private val noteDao: NoteDao) : DataBaseRepository {

    override suspend fun insertNote(
        noteModel: NoteModel,
        onSuccess: () -> Unit,
        onFail: () -> Unit
    ) {
        onSuccess()
        noteDao.insertNote(noteModel)
    }

    override suspend fun deleteNote(noteModel: NoteModel) {
        noteDao.deleteNote(noteModel)
    }

    override fun getAllNote(): LiveData<List<NoteModel>> {
        return noteDao.getAllNote()
    }

    override suspend fun editNote(noteModel: NoteModel) {
        noteDao.editNote(noteModel)
    }

    override fun getNoteByID(id: Long,onSuccess: () -> Unit, onFail: () -> Unit): LiveData<NoteModel> {
        onFail()
        onSuccess()
        return noteDao.getNoteByID(id)
    }

    override fun findNoteByTheme(noteTheme: String): LiveData<List<NoteModel>> {
        return noteDao.findNoteByTheme(noteTheme)
    }


}