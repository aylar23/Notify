package com.aylar.notify.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.aylar.notify.domain.models.Note
import com.aylar.notify.domain.models.TrashNote

data class TrashNoteWithNotes(
    @Embedded val trashNote: TrashNote,
    @Relation(
        parentColumn = "noteId",
        entityColumn = "id"
    )
    val note: Note,
)
