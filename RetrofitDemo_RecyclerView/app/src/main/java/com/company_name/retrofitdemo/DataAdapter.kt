package com.company_name.retrofitdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.currentCoroutineContext
import org.w3c.dom.Text

class DataAdapter(private val context: MainActivity, private val data_from_api: List<MyDataItem>) :
    RecyclerView.Adapter<DataAdapter.DataView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataView {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        return DataView(view)

    }

    override fun onBindViewHolder(holder: DataView, position: Int) {
        val curr = data_from_api[position]
        holder.title.text = curr.title
        holder.id.text = curr.id.toString()
        holder.body.text = curr.body

    }

    override fun getItemCount(): Int {
        return data_from_api.size
    }


    class DataView(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var body: TextView = itemView.findViewById(R.id.tv_body)
        var id: TextView = itemView.findViewById(R.id.tv_id)
        var title: TextView = itemView.findViewById(R.id.tv_title)
    }

}