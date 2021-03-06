package com.example.vegandiary.MemoDB


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Memo(@PrimaryKey(autoGenerate = true) var id: Long?,
           @ColumnInfo(name = "title") var title:String,
           @ColumnInfo(name = "content") var content:String,
           @ColumnInfo(name = "time") var time: String
           ) { //아이템 생성
    constructor() : this(null, "", "", "")
}