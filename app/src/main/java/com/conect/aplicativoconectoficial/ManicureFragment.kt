package com.conect.aplicativoconectoficial

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.conect.aplicativoconectoficial.databinding.FragmentBarbeariaBinding
import com.conect.aplicativoconectoficial.databinding.FragmentManicureBinding

class ManicureFragment: Fragment(R.layout.fragment_manicure) {

    private var binding: FragmentManicureBinding? = null

    private val categoriaAdapter = ATAdapter({
        CategoriasView(it)
    })

    private var filtros = arrayOf(

        FiltrarItem(1,"Ordenar", closeicon = R.drawable.ic_setabaixo),
        FiltrarItem(2,"Distância", closeicon = R.drawable.ic_distancia),
        FiltrarItem(4,"Promoção", icon = R.drawable.ic_promocao),
        FiltrarItem(5,"Filtros", closeicon = R.drawable.ic_filtro),

    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoriaAdapter.items = arrayListOf(
            Categorias(1, "https://img3.gratispng.com/dy/bbec1a0515157d5b15d25e4aa0e419bc/L0KzQYm3U8I3N5N4fZH0aYP2gLBuTf5icZ0yeeR9LX3kfrrqlgJmNZ9mgd42cHBvecTvTf5icZ0yTdNrOHa1doS7gfY0bWozT6oCNUC4QoS4VcIzOGg1SqcEM0C6PsH1h5==/kisspng-nail-art-manicure-nail-polish-nail-5ab8f2f34af3e9.787505231522070259307.png", "Mãos", 0xFFB6D048),
            Categorias(2, "https://img3.gratispng.com/dy/42193cd4912fabd8c9af312b54b5cf8d/L0KzQYm3U8I5N5N6j5H0aYP2gLBuTgBmbJpojeRuLX3kfrrqlgJmNZhqhJ93YXnvg37phfF2fKoyiNN7bHB4gn71gflte146edRrMUXpR7boUvQ4QV89S6k6M0O7SIK8UsIzOWE3UacENUm1PsH1h5==/kisspng-pedicure-manicure-gel-nails-beauty-parlour-nails-5abb15f7ea2d79.8371338815222102959592.png", "Pés", 0xFFE91D2D),
            )

        binding = FragmentManicureBinding.bind(view)

        binding?.let {
            it.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.recyclerViewCategory.adapter = categoriaAdapter
            filtros.forEach { filtros->
                it.chipGroup.addView(filtros.toChip((requireContext())))
            }
        }
    }
}

