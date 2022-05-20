package com.example.notesv2.data.repository

import com.example.notesv2.core.Visibility
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.repositories.EmptyVisibilityRepository

class EmptyVisibilityRealization : EmptyVisibilityRepository {

    override fun visible(list: List<Notes>) =
        if (list.isEmpty()) Visibility.Visible() else Visibility.InVisible()
}