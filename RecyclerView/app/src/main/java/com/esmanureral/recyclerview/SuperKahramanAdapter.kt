package com.esmanureral.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esmanureral.recyclerview.databinding.RecylerRowBinding
// RecyclerView kullanarak  Süper Kahraman Listesi oluşturmak için Adapter sınıfı
class SuperKahramanAdapter(val superKahramanListesi:ArrayList<SuperKahraman>):RecyclerView.Adapter<SuperKahramanAdapter.SuperKahramanViewHolder>() {
    class SuperKahramanViewHolder(val binding: RecylerRowBinding):RecyclerView.ViewHolder(binding.root)
    /*RecylerRowBinding kullanarak tasarım recyler_row.xml baglandı  */


    //ViewHolder'ın objesini oluşturmak için(Görünüm Oluşturma)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperKahramanViewHolder {
       val binding=RecylerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SuperKahramanViewHolder(binding)
    }

    //oluşturulmuş RecyclerView kaç tane yapsın( Eleman Sayısı)
    override fun getItemCount(): Int {
        return superKahramanListesi.size //listenin içindeki kaç tane eleman varsa
    }

    //işlemler bitince ne olsun(Verilerin Görünüme Bağlanması)
    override fun onBindViewHolder(holder: SuperKahramanViewHolder, position: Int) {
        holder.binding.textViewRecylerView.text=superKahramanListesi[position].isim

    //reccylerview de öğelere tıklandıgında açılacak sayfa için
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,TanitimAktivitesi::class.java)
            intent.putExtra("secilenKahraman",superKahramanListesi[position]) //hata vermeme sebebi SuperKahraman classını serializable yapmamızdır.
            holder.itemView.context.startActivity(intent)

        }
    }
}