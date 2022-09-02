package com.example.roomtest.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomtest.REPOSITORY
import com.example.roomtest.db.NoteDatabase
import com.example.roomtest.db.repository.NoteRealization
import com.example.roomtest.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application
    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }
    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes

    }
}