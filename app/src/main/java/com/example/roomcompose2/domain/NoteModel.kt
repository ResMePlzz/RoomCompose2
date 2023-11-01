package com.example.roomcompose2.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "noteTheme")
    val noteTheme: String = "",
    @ColumnInfo(name = "noteText")
    val noteText: String = "")

