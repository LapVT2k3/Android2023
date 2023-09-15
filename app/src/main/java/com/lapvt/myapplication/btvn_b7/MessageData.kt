package com.lapvt.myapplication.btvn_b7

import android.os.Parcel
import android.os.Parcelable

data class MessageData(val id: Int, val image: Int, var title: String?, var content: String?) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(image)
        parcel.writeString(title)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MessageData> {
        override fun createFromParcel(parcel: Parcel): MessageData {
            return MessageData(parcel)
        }

        override fun newArray(size: Int): Array<MessageData?> {
            return arrayOfNulls(size)
        }
    }

}
