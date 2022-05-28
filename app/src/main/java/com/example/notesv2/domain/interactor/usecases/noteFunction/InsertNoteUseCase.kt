package com.example.notesv2.domain.interactor.usecases.noteFunction

import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.Repository
import javax.inject.Inject

class InsertNoteUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun invoke(item: Notes) = repository.insert(item)
}