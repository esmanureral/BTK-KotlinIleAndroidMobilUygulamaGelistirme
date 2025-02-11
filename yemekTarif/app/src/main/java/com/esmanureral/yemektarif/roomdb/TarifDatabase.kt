package com.esmanureral.yemektarif.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.esmanureral.yemektarif.model.Tarif

@Database(entities = [Tarif::class], version = 1)
abstract class TarifDatabase:RoomDatabase(){
    abstract fun tarifDao():TarifDAO
}