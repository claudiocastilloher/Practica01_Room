package com.claudiocastillo.practica01_room

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.claudiocastillo.practica01_room.data.Pastel
import com.claudiocastillo.practica01_room.data.PastelDatabase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val database = PastelDatabase.getDatabase(this)
        val pastelDao = database.pastelDao()

        //insertar una pastel en la base de datos.
        lifecycleScope.launch {
            //insertamos un pastel de prueba
            pastelDao.insertarPastel(Pastel(nombre = "Pastelito Rick_Dev", rebanadas = 12))

            //Obtenemos los pasteles y configuramos el daptador
            val pasteles = pastelDao.obtenerTodosLosPasteles()
            val adapter = PastelAdapter(pasteles)
            recyclerView.adapter = adapter
        }
    }
}