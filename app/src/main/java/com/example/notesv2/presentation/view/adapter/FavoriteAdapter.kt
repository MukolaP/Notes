package com.example.notesv2.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.notesv2.core.AbstractRecyclerAdapter
import com.example.notesv2.core.AbstractViewHolder
import com.example.notesv2.core.Mapper
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.databinding.FragmentNotesItemBinding
import com.example.notesv2.presentation.model.WidgetsNotes
import com.example.notesv2.presentation.viewmodel.FavoriteViewModel
import com.example.notesv2.presentation.ui.FavoriteUi

class FavoriteAdapter(
    private val viewModel: FavoriteViewModel,
) : AbstractRecyclerAdapter<Notes, FavoriteViewHolder>(), Mapper.Unit<List<Notes>> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FavoriteViewHolder(
        viewModel,
        FragmentNotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
    )
}

class FavoriteViewHolder(
    private val viewModel: FavoriteViewModel, binding: FragmentNotesItemBinding,
) : AbstractViewHolder<Notes>(binding.root) {

    private val themeView: TextView = binding.content
    private val favoriteBT: Button = binding.favorite
    private val deleteBT: Button = binding.delete

    private val mapper = FavoriteUi.Mapper.Ui(WidgetsNotes(themeView, favoriteBT), viewModel)

    override fun bind(data: Notes) {
        mapper.map(data)

        themeView.setOnClickListener {
            FavoriteUi.Mapper.Theme(viewModel).map(data)
        }

        deleteBT.setOnClickListener {
            FavoriteUi.Mapper.Delete(viewModel).map(data)
        }

        favoriteBT.setOnClickListener {
            favoriteBT.setBackgroundResource(FavoriteUi.Mapper.Favorite(viewModel).map(data))
        }
    }
}