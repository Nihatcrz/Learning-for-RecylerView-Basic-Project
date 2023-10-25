package com.example.deneme

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deneme.databinding.RecylerLayoutBinding

class Recycler_Adapteri (val takimList: ArrayList<Takimlar> /*bu parantez içinde listeye ulaşmak için constructor yaptık*/) : RecyclerView.Adapter<Recycler_Adapteri.RecyclerHolder>() {

    class RecyclerHolder(val binding: RecylerLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        val binding = RecylerLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false) //RecylerLayoutBinding.inflate yaptık çünkü yarattığım recycler_layout.xml de görünecek liste görünümü
        return RecyclerHolder(binding) //görünümü bu şekilde bağladık yukarıda oluşturduğum RecyclerHolder classı ile birlikte
    }

    override fun getItemCount(): Int {
        return takimList.size
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.binding.recyclerText.text = takimList.get(position).name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,Details::class.java)
            intent.putExtra("intentDetails",takimList.get(position))
            holder.itemView.context.startActivity(intent) }
    } //burada textviewlerde falan ne gözükeceğini ayarlayacağız onbindviewholderde.
}