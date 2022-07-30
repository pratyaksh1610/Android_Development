package com.example.notesrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesrecyclerview.NotesAdapter.*
import kotlinx.android.synthetic.main.item.view.*


class NotesAdapter(private var items: List<NotesData>, var listener: MainActivity) :
    RecyclerView.Adapter<NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val curr = items[position]
        holder.tv.text = curr.note
        holder.del.setOnClickListener {
            listener.callDel(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView = itemView.tv
        val del: Button = itemView.del
    }
}