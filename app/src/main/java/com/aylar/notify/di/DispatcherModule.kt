package com.aylar.notify.di

import com.aylar.notify.core.DispatcherProvider
import com.aylar.notify.core.DispatcherProviderImpl
import com.aylar.notify.domain.repository.trash.TrashNoteRepoImpl
import com.aylar.notify.domain.repository.trash.TrashNoteRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Binds
    abstract fun bindDispatcherProvider(
        dispatcherProvider: DispatcherProviderImpl,
    ): DispatcherProvider

    @Binds
    abstract fun bindTrashRepo(
        trashNoteRepository: TrashNoteRepoImpl,
    ): TrashNoteRepo
}
