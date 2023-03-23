package com.example.note.Model

import android.text.Editable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        @ColumnInfo(name = "Email") val Email: String,
        @ColumnInfo(name = "User") val User: String,
        @ColumnInfo(name = "Pass") val Pass: String,
        @ColumnInfo(name = "Pass2") val Pass2: String
)