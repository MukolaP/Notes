package com.example.notesv2.presentation.screens.detail

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.usecases.noteFunction.FindByUidNoteUseCase
import com.example.notesv2.domain.usecases.noteFunction.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val findByUidNoteUseCase: FindByUidNoteUseCase
) : BaseViewModel() {

    fun update(notes: Notes) =
        viewModelScope.launch {
            updateNoteUseCase.invoke(notes)
        }

    fun findByUid(uid: Int) = findByUidNoteUseCase.invoke(uid)

    fun saveCLick(item: Notes, findNavController: NavController, navigate: Boolean) {
        navigateTo(findNavController, navigate)
        update(Notes(uid = item.uid, theme = item.theme, content = item.content))
    }

    fun navigateTo(findNavController: NavController, navigate: Boolean) {
        if (navigate) findNavController.navigate(R.id.navigation_home)
        else findNavController.navigate(R.id.navigation_favorite)
    }
}
