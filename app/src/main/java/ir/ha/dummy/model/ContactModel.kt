package ir.ha.dummy.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@SuppressLint("ParcelCreator")
@Entity
class ContactModel():Parcelable{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var uid : Long? = null
    @ColumnInfo
    var fName : String? = null
    @ColumnInfo
    var lName : String? = null

    constructor(parcel: Parcel) : this() {
        uid = parcel.readValue(Long::class.java.classLoader) as? Long
        fName = parcel.readString()
        lName = parcel.readString()
    }

    constructor(fName : String , lName : String) : this(){
        this.fName = fName
        this.lName = lName
    }
    constructor(uid : Long , fName : String , lName : String) : this(){
        this.uid = uid
        this.fName = fName
        this.lName = lName
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(uid)
        parcel.writeString(fName)
        parcel.writeString(lName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactModel> {
        override fun createFromParcel(parcel: Parcel): ContactModel {
            return ContactModel(parcel)
        }

        override fun newArray(size: Int): Array<ContactModel?> {
            return arrayOfNulls(size)
        }

        fun fullName(contactModel : ContactModel) : String {
            return contactModel.fName + " " + contactModel.lName
        }
    }
}