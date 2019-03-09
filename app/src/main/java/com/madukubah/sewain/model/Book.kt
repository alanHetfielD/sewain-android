package com.madukubah.sewain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Book (
        @SerializedName("book_id") val book_id : Long,
        @SerializedName("book_title") val book_title : String,
        @SerializedName("book_author") val book_author : String,
        @SerializedName("book_release") val book_release : String,
        @SerializedName("book_ISBN") val book_ISBN : String,
        @SerializedName("book_language") val book_language : String,
        @SerializedName("book_penerbit") val book_penerbit : String,
        @SerializedName("book_weight") val book_weight : String,
        @SerializedName("book_width") val book_width : String,
        @SerializedName("book_length") val book_length : String,
        @SerializedName("book_desc") val book_desc : String,
        @SerializedName("book_page_count") val book_page_count : String
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(book_id)
        parcel.writeString(book_title)
        parcel.writeString(book_author)
        parcel.writeString(book_release)
        parcel.writeString(book_ISBN)
        parcel.writeString(book_language)
        parcel.writeString(book_penerbit)
        parcel.writeString(book_weight)
        parcel.writeString(book_width)
        parcel.writeString(book_length)
        parcel.writeString(book_desc)
        parcel.writeString(book_page_count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }
}