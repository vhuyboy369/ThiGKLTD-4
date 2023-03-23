package com.example.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import com.example.note.R
import com.example.note.database.NoteRoomDatabase
import com.example.note.Model.Note
import kotlinx.android.synthetic.main.activity_new_note.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NewNoteActivity : AppCompatActivity(), CoroutineScope {

    private var noteDB: NoteRoomDatabase? = null

    private lateinit var mJob: Job
    override val coroutineContext: CoroutineContext
        get() = mJob + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        mJob = Job()

        noteDB = NoteRoomDatabase.getDatabase(this)

        button.setOnClickListener {
            launch {
                val strEmail: String = email.text.toString()
                val strUser: String = user.text.toString()
                val strPass: String = user.text.toString()
                val strPass2: String = user.text.toString()
                noteDB?.noteDao()?.insert(Note(Email = strEmail, User = strUser, Pass = strPass, Pass2 = strPass2))

                finish()
            }
        }
    }
}