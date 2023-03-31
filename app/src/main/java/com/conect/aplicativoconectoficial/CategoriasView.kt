package com.conect.aplicativoconectoficial

import android.graphics.drawable.GradientDrawable
import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.conect.aplicativoconectoficial.databinding.CategoriaItensBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class CategoriasView(viewGroup: ViewGroup): ATViewHolder<Categorias, CategoriaItensBinding>(
    CategoriaItensBinding::inflate,
    viewGroup
) {
    override fun bind(item: Categorias) {
        binding.textCategoria.text = item.nome

        Picasso.get()
            .load(item.logo_url)
            .into(binding.imagemCategoria, object : Callback{
                override fun onSuccess() {
                    val shape = GradientDrawable()
                    shape.cornerRadius = 10f

                    shape.setColor((item.cor.toInt()))

                    binding.bgCategoria.background = shape
                }

                override fun onError(e: Exception?) {
                    TODO("Not yet implemented")
                }
            })
    }

}