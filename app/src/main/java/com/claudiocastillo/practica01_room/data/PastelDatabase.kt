package com.claudiocastillo.practica01_room.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pastel::class], version = 1, exportSchema = false)
abstract class PastelDatabase : RoomDatabase() {

    abstract fun pastelDao(): PastelDao

    companion object{
        @Volatile
        private var INSTANCE: PastelDatabase? = null

        fun getDatabase(context: Context): PastelDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PastelDatabase::class.java,
                "pastel_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}