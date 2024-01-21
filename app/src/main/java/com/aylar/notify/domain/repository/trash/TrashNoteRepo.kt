package com.aylar.notify.domain.repository.trash

import com.aylar.notify.data.relations.TrashNoteWithNotes
import com.aylar.notify.domain.models.TrashNote
import java.time.LocalDateTime

interface TrashNoteRepo {
    suspend fun getTrashNotes(): List<TrashNote>
    suspend fun deleteTrashNoteById(noteId: Int)
    suspend fun upsertTrashNote(trashNote: TrashNote)
    suspend fun getTrashNoteWithNote(): List<TrashNoteWithNotes>

    /**
     * @return list of ids for notes to delete to noteRepository
     */
    suspend fun getTrashNotePeriodHasExceeded(localDateTime: LocalDateTime = LocalDateTime.now()): List<Int>
}
