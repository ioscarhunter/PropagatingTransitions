package com.starboy.propagatingtransitions

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class ItemAdapter(private val items: List<ItemModel>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
            ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_card, parent, false))

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        items[position].run {
            holder.image.setImageResource(imageId)
            holder.title.text = title
            holder.description.text = description
        }
    }
}