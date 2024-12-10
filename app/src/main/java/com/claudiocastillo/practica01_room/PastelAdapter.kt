package com.claudiocastillo.practica01_room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claudiocastillo.practica01_room.data.Pastel
import com.claudiocastillo.practica01_room.databinding.ItemPastelBinding

class PastelAdapter(private val listaPasteles: List<Pastel>) : RecyclerView.Adapter<PastelAdapter.PastelViewHolder>(){

//ViewHolder que utiliza ViewBinging
    class PastelViewHolder(private val binding: ItemPastelBinding): RecyclerView.ViewHolder(binding.root){

        //Método para enlazar los datos con las vistas
        fun  bind(pastel: Pastel){
            binding.tvNombre.text = pastel.nombre
            binding.tvRebanadas.text = "Rebanadas: ${pastel.rebanadas}"
        }
    }

    //Infla el layout y crea el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastelViewHolder {
        val binding = ItemPastelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PastelViewHolder(binding)
    }

    //Enlaza los datos con el ViewHolder
    override fun onBindViewHolder(holder: PastelViewHolder, position: Int) {
        holder.bind(listaPasteles[position])
    }

    //Retorna el tamaño de la lista
    override fun getItemCount(): Int {
        return listaPasteles.size
    }


}