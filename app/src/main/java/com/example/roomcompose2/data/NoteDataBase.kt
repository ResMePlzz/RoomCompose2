package com.example.roomcompose2.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomcompose2.domain.NoteModel
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {
        private var INSTANCE: NoteDataBase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: android.content.Context): NoteDataBase {
            return INSTANCE ?: kotlinx.coroutines.internal.synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDataBase::class.java,
                    "chat_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}