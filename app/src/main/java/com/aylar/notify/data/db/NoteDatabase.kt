package com.aylar.notify.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aylar.notify.data.converters.DateTypeConverter
import com.aylar.notify.data.converters.ListConverter
import com.aylar.notify.data.converters.LocalDateTimeConverter
import com.aylar.notify.data.converters.UriConverter
import com.aylar.notify.data.dao.NoteDao
import com.aylar.notify.data.dao.TrashNoteDao
import com.aylar.notify.domain.models.Note
import com.aylar.notify.domain.models.TrashNote

@Database(entities = [Note::class, TrashNote::class], version = 4)
@TypeConverters(DateTypeConverter::class, UriConverter::class, ListConverter::class, LocalDateTimeConverter::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
    abstract val trashNote: TrashNoteDao

    companion object {
        @Suppress("ktlint:standard:property-naming")
        private var INSTANCE: NoteDatabase? = null
        fun getInstance(context: Context): NoteDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "Note_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
