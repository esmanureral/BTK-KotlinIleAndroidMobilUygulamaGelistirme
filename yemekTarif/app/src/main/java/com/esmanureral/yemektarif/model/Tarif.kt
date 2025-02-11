package com.esmanureral.yemektarif.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//ROOM İÇİN
@Entity
class Tarif (
    @ColumnInfo(name="isim") //sütun ismi
    var isim:String,

    @ColumnInfo(name="malzeme")
    var malzeme:String,

    @ColumnInfo(name = "gorsel")
    var gorsel:ByteArray

)
{
    @PrimaryKey(autoGenerate = true)
    var id=0
}