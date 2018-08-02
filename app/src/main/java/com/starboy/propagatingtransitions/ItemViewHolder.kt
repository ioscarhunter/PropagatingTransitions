package com.starboy.propagatingtransitions

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val image: ImageView = view.findViewById(R.id.imageView)
    val title: TextView = view.findViewById(R.id.titleText)
    val description: TextView = view.findViewById(R.id.descText)
}