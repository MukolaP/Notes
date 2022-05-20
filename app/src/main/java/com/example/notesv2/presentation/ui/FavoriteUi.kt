package com.example.notesv2.presentation.ui

import android.widget.Button
import android.widget.TextView
import com.example.notesv2.core.AbstractUi
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.presentation.screens.favorite.FavoriteViewModel
import kotlinx.coroutines.Job

interface FavoriteUi : AbstractUi {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {

        fun map(item: Notes): T

        class Ui(
            private val widgets: Widgets,
            private val viewModel: FavoriteViewModel,
        ) : Mapper<Unit> {

            override fun map(item: Notes) {
                widgets.themeView.text = item.theme
                widgets.favoriteBT.setBackgroundResource(viewModel.likeShow(item))
            }
        }

        class Theme(
            private val viewModel: FavoriteViewModel,
        ) : Mapper<Unit> {

            override fun map(item: Notes) =
                viewModel.themeClick(item.uid)
        }

        class Delete(
            private val viewModel: FavoriteViewModel,
        ) : Mapper<Job> {

            override fun map(item: Notes) = viewModel.delete(item)
        }

        class Favorite(
            private val viewModel: FavoriteViewModel,
        ) : Mapper<Int> {

            override fun map(item: Notes) = viewModel.like(item)
        }
    }

    data class Widgets(
        val themeView: TextView,
        val favoriteBT: Button,
    )
}

