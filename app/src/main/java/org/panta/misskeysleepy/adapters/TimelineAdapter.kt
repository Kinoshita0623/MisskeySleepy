package org.panta.misskeysleepy.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import org.panta.misskeysleepy.R
import org.panta.misskeysleepy.databinding.ItemNoteBinding
import org.panta.misskeysleepy.entities.Note
import org.panta.misskeysleepy.viewmodel.NoteViewModel

class NoteViewHolder(val noteBinding: ItemNoteBinding) : RecyclerView.ViewHolder(noteBinding.root)
class TimelineAdapter : RecyclerView.Adapter<NoteViewHolder>(){
    init{
        Log.d("TimelineAdapter", "インスタンス化されました")
    }
    var list = listOf<Note>()
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: NoteViewHolder, p1: Int) {
        Log.d("TimelineAdapter", "onBindViewHolder")
        p0.noteBinding.viewModel = NoteViewModel().apply{
            setContent(list[p1])
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteViewHolder {
        val binding = DataBindingUtil.inflate<ItemNoteBinding>(LayoutInflater.from(p0.context), R.layout.item_note, p0,false)
        return NoteViewHolder(binding)
    }
}