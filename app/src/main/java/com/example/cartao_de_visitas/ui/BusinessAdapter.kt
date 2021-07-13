package com.example.cartao_de_visitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cartao_de_visitas.data.DataBusinessCard
import com.example.cartao_de_visitas.databinding.ItemBusinessCardBinding

class BusinessAdapter() : RecyclerView.Adapter<ViewHolderBusiness>() {

    private var listBusiness : List<DataBusinessCard> = arrayListOf()
    lateinit var listenerShare : ((View) -> Unit)

    fun submitList(listBusiness : List<DataBusinessCard>){
        this.listBusiness = listBusiness
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBusiness {
        val binding = ItemBusinessCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderBusiness(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderBusiness, position: Int) {
        val card = listBusiness[position]
        val binding = holder.binding

        binding.txNome.text = card.nome
        binding.txNomeEmpresa.text = card.empresa
        binding.txEmail.text = card.email
        binding.txTelefone.text = card.telefone
        binding.cardItem.setBackgroundColor(Color.parseColor(card.fundoPersonalizado))

        holder.itemView.setOnClickListener {
            listenerShare(it)
        }
    }

    override fun getItemCount(): Int = listBusiness.size
}

class ViewHolderBusiness(val binding : ItemBusinessCardBinding) : RecyclerView.ViewHolder(binding.root) {

}
