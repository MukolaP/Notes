package com.example.notesv2.data.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesv2.R
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.repositories.FavoriteChangeRepository
import com.example.notesv2.domain.usecases.noteFunction.UpdateNoteUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteChangeRealization @Inject constructor(
    private val updateNoteUseCase: UpdateNoteUseCase
) : ViewModel(), FavoriteChangeRepository {

    override fun likeShow(notes: Notes) =
        if (notes.isLike)
            LIKE_ICON
        else
            DISLIKE_ICON

    override fun like(notes: Notes): Int {
        notes.isLike = !notes.isLike

        viewModelScope.launch {
            updateNoteUseCase.invoke(notes)
        }

        return likeShow(notes)
    }

    companion object {
        const val LIKE_ICON = R.drawable.ic_baseline_favorite_24
        const val DISLIKE_ICON = R.drawable.ic_baseline_favorite_border_24
    }

}