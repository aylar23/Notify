package com.aylar.notify.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.aylar.notify.data.db.NoteDatabase
import com.aylar.notify.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    fun provideDataStoreUtil(@ApplicationContext context: Context): DataStoreUtil = DataStoreUtil(context)

    @Provides
    fun provideRepository(application: Application): NoteRepository {
        return NoteRepository(application)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "Note_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTrashNote(noteDatabase: NoteDatabase) = noteDatabase.trashNote
}
