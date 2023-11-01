package com.example.roomcompose2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.roomcompose2.domain.NoteModel


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(noteModel: NoteModel)

    @Delete
    suspend fun deleteNote(noteModel: NoteModel)


    @Query("SELECT * FROM note_table")
    fun getAllNote(): LiveData<List<NoteModel>>


    @Update
    suspend fun editNote(noteModel: NoteModel)


    @Query("SELECT * FROM note_table WHERE id = :id")
    fun getNoteByID(id: Long): LiveData<NoteModel>



    @Query("SELECT * FROM note_table WHERE noteTheme = :noteTheme ")
    fun findNoteByTheme(noteTheme: String): LiveData<List<NoteModel>>

}
