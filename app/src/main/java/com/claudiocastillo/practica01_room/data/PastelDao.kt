package com.claudiocastillo.practica01_room.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomWarnings

@Dao
interface PastelDao {
    @Insert //Insertar un nuevo pastel.
    suspend fun insertarPastel(pastel: Pastel)

    @Query("SELECT * FROM pastel_table")//Obtener todos los pasteles
    suspend fun obtenerTodosLosPasteles(): List<Pastel>
}