package com.claudiocastillo.practica01_room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pastel_table")//Definimos el nombre de la tabla
data class Pastel(
    @PrimaryKey(autoGenerate = true)//La clave primaria se generará automáticamente
    val id: Int = 0,
    val nombre: String,//Nombre del pastel
    val rebanadas: Int //Número de reabanadas
)
