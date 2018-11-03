package com.example.dev.pola.model

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

class Placemark(
    val address: String? = null,

    val coordinates: ArrayList<Double>? = null,

    val engineType: String? = null,

    val exterior: String? = null,

    val fuel: Int = 0,

    val interior: String? = null,

    val name: String? = null,

    val vin: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        ArrayList<Double>().apply { source.readList(this, Double::class.java.classLoader) },
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(address)
        writeList(coordinates)
        writeString(engineType)
        writeString(exterior)
        writeInt(fuel)
        writeString(interior)
        writeString(name)
        writeString(vin)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Placemark> = object : Parcelable.Creator<Placemark> {
            override fun createFromParcel(source: Parcel): Placemark = Placemark(source)
            override fun newArray(size: Int): Array<Placemark?> = arrayOfNulls(size)
        }
    }
}
