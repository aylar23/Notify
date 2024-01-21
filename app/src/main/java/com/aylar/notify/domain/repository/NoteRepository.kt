package com.aylar.notify.domain.repository

import android.app.Application
import com.aylar.notify.data.dao.NoteDao
import com.aylar.notify.data.db.NoteDatabase
import com.aylar.notify.domain.models.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(application: Application) {

    private var noteDao: NoteDao

    init {
        val database = NoteDatabase.getInstance(application)
        noteDao = database.noteDao()
    }
    suspend fun deleteNoteById(noteId: Int) {
        noteDao.deleteNoteById(noteId)
    }
    fun getAllNotesFromRoom(): Flow<List<Note>> = noteDao.getAllNotes()

    fun getNoteByIdFromRoom(noteId: Int): Flow<Note?> = noteDao.getNoteByIdFlow(noteId)

    suspend fun insertNoteToRoom(note: Note): Long = noteDao.insertNote(note)

    suspend fun insertListOfNotesToRoom(notes: List<Note>): List<Long> = noteDao.insertListOfNotes(notes)
    fun getNoteById(noteId: Int): Note? = noteDao.getNoteById(noteId)

    suspend fun updateNoteInRoom(note: Note) = noteDao.updateNote(note)

    suspend fun deleteNoteFromRoom(note: Note) = noteDao.deleteNote(note)

    suspend fun deleteNotesFromRoom(noteList: List<Note>) = noteDao.deleteListOfNote(noteList)
}
