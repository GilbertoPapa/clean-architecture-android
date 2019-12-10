package com.raywenderlich.android.majesticreader.common

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

object GenericViewHolderFactory{

    fun create(view: View, viewType: Int,position : Int, layout : Int): RecyclerView.ViewHolder {
        return when (viewType) {
            layout -> GenericViewHolder(view,position)

            else -> {
                GenericViewHolder(view,position)
            }
        }
    }


    class GenericViewHolder(itemView: View, position: Int) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<GenericModel> {

        var tvTitle: TextView = itemView.findViewById(position)
        var tvSubTitle: TextView = itemView.findViewById(position)

        override fun bind(model: GenericModel) {
            tvTitle.text = model.title
            tvSubTitle.text = model.subTitle
        }
    }



}