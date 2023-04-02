package com.conect.aplicativoconectoficial

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.conect.aplicativoconectoficial.databinding.EstabelecimentoItemBinding
import com.conect.aplicativoconectoficial.databinding.MaisEstabelecimentosBinding
import com.squareup.picasso.Picasso

class MaisEstabelecimentosView(viewGroup: ViewGroup): ATViewHolder<MaisEstabelecimentos, MaisEstabelecimentosBinding>(
    MaisEstabelecimentosBinding::inflate,
    viewGroup
) {
    override fun bind(item: MaisEstabelecimentos) {
        Picasso.get()
            .load(item.banner_url)
            .into(binding.imgEstabelecimentos)

        binding.textEstab.text =  item.texto
        binding.textStar.text = item.avaliacao.toString()
        binding.textCategoria.text = itemView.context.getString(R.string.categoria_estabelecimentos, item.categoria, item.distancia)
    }



}