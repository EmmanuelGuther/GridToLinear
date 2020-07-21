package com.emmanuelguther.gridtolinear

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import kotlin.properties.Delegates


class MyListAdapter constructor() : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {
    internal var collection: List<MyListData> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            parent.inflate(R.layout.list_item)
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(
        collection[position])

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            model: MyListData
        ) {
            itemView.title.text = model.description
            itemView.image.setImageResource( model.imgId)
        }
    }
}

fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)
