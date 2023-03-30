package com.conect.aplicativoconectoficial

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.conect.aplicativoconectoficial.databinding.CategoriaItensBinding
import com.squareup.picasso.Picasso

class CategoriasView(viewGroup: ViewGroup): ATViewHolder<Categorias, CategoriaItensBinding>(
    CategoriaItensBinding::inflate,
    viewGroup
) {
    override fun bind(item: Categorias) {
        binding.textCategoria.text = item.nome

        Picasso.get()
            .load(item.logo_url)
            .into(binding.imagemCategoria)
    }

}