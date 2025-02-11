package com.esmanureral.yemektarif.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.esmanureral.yemektarif.databinding.RecylerRowBinding
import com.esmanureral.yemektarif.model.Tarif
import com.esmanureral.yemektarif.view.ListeFragmentDirections

class TarifAdapter(val tarifListesi:List<Tarif>) : RecyclerView.Adapter<TarifAdapter.TarifHolder>(){
    class TarifHolder(val binding:RecylerRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarifHolder {
        val recylerRowBinding=RecylerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TarifHolder(recylerRowBinding)
    }

    override fun getItemCount(): Int {
        return tarifListesi.size
    }

    override fun onBindViewHolder(holder: TarifHolder, position: Int) {
        holder.binding.recylerViewTextView.text=tarifListesi[position].isim
        holder.itemView.setOnClickListener {
            val action=ListeFragmentDirections.actionListeFragmentToTarifFragment(bilgi = "eski",id=tarifListesi[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}