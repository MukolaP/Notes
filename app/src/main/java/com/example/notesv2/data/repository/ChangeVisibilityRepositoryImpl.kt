package com.example.notesv2.data.repository

import com.example.notesv2.core.Visibility
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.ChangeVisibilityRepository
import javax.inject.Inject

class ChangeVisibilityRepositoryImpl @Inject constructor() : ChangeVisibilityRepository {

    override fun changeVisibility(list: List<Notes>) =
        if (list.isEmpty()) Visibility.Visible() else Visibility.InVisible()
}