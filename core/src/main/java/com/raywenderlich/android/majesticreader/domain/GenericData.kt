package com.raywenderlich.android.majesticreader.domain

import java.io.Serializable

data class GenericData (
        val title: String,
        val subTitle: String
):Serializable {
    companion object {
        val EMPTY = GenericData("","")
    }
}