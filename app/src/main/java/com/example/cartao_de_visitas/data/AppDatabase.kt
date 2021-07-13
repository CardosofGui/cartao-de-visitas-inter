package com.example.cartao_de_visitas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataBusinessCard::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun businessDao() : BusinessCardDao

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businesscard_db"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}