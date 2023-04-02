package com.conect.aplicativoconectoficial

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.conect.aplicativoconectoficial.databinding.EstabelecimentoItemBinding
import com.squareup.picasso.Picasso

class EstabelecimentosView(viewGroup: ViewGroup): ATViewHolder<Estabelecimentos, EstabelecimentoItemBinding>(
    EstabelecimentoItemBinding::inflate,
    viewGroup
) {
    override fun bind(item: Estabelecimentos) {
        Picasso.get()
            .load(item.banner_url)
            .into(binding.imgEstabelecimentos)
    binding.textEstab.text = item.texto
    }



}