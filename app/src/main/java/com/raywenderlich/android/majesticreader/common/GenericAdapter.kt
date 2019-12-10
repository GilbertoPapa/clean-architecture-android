package com.raywenderlich.android.majesticreader.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.majesticreader.domain.GenericData
import kotlinx.android.synthetic.main.car_layout.view.*

abstract class GenericAdapter (private val list: MutableList<GenericData> = mutableListOf(),
private val itemClickListener: (GenericData) -> Unit
) : RecyclerView.Adapter<GenericAdapter.ViewHolder>()  {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.tvTitle
        val subTitleTextView: TextView = view.tvSubTitle
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int,layout: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(layout, parent, false)
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.run {
        holder.titleTextView.text = list[position].title
        holder.subTitleTextView.text = list[position].subTitle
        holder.itemView.setOnClickListener { itemClickListener.invoke(list[position]) }
    }

    fun update(newData: List<GenericData>) {
        list.clear()
        list.addAll(newData)

        notifyDataSetChanged()
    }

}